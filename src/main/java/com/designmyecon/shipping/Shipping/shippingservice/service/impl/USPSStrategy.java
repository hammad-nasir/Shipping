package com.designmyecon.shipping.Shipping.shippingservice.service.impl;

import com.designmyecon.shipping.Shipping.model.dto.OAuthTokenResponse;
import com.designmyecon.shipping.Shipping.model.dto.ShippingRequest;
import com.designmyecon.shipping.Shipping.model.dto.ShippingResponse;
import com.designmyecon.shipping.Shipping.model.dto.USPSPricingRequest;
import com.designmyecon.shipping.Shipping.shippingservice.service.CarrierStrategy;
import com.designmyecon.shipping.Shipping.model.enums.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class USPSStrategy implements CarrierStrategy {

    @Value("${usps.oauth.token.url}")
    private String oauthTokenUrl;

    @Value("${usps.api.pricing.url}")
    private String pricingUrl;

    @Value("${usps.client.id}")
    private String clientId;

    @Value("${usps.client.secret}")
    private String clientSecret;

    private final WebClient webClient;

    public USPSStrategy(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String getCarrierName() {
        return "USPS";
    }

    @Override
    public ShippingResponse calculate(ShippingRequest request) {
        // Step 1: Retrieve OAuth token
        OAuthTokenResponse tokenResponse = webClient.post()
                .uri(oauthTokenUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("grant_type=client_credentials&client_id=" + clientId
                        + "&client_secret=" + clientSecret
                        + "&scope=domestic-prices")
                .retrieve()
                .bodyToMono(OAuthTokenResponse.class)
                .block();

        if (tokenResponse == null || tokenResponse.getAccessToken() == null) {
            throw new RuntimeException("Failed to retrieve OAuth token");
        }

        String accessToken = tokenResponse.getAccessToken();

        // Step 2: Construct UspsPricingRequest model
        USPSPricingRequest pricingRequest = new USPSPricingRequest();
        pricingRequest.setOriginZIPCode(request.getOriginZip());
        pricingRequest.setDestinationZIPCode(request.getDestinationZip());
        pricingRequest.setWeight(request.getWeight());
        pricingRequest.setLength(0.0);   // Replace with actual value if available
        pricingRequest.setWidth(0.0);    // Replace with actual value if available
        pricingRequest.setHeight(0.0);   // Replace with actual value if available
        pricingRequest.setMailClass(MailClass.USPS_GROUND_ADVANTAGE);
        pricingRequest.setProcessingCategory(ProcessingCategory.MACHINABLE);
        pricingRequest.setRateIndicator(RateIndicator.SP);
        pricingRequest.setDestinationEntryFacilityType(DestinationEntryFacilityType.NONE);
        pricingRequest.setPriceType("COMMERCIAL");
        pricingRequest.setMailingDate("2025-07-01");  // Ideally, use a dynamic date
        pricingRequest.setAccountType("EPS");
        pricingRequest.setAccountNumber("1234567890");

        // Step 3: Call the USPS pricing API using the model
        ShippingResponse shippingResponse = webClient.post()
                .uri(pricingUrl)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(pricingRequest)
                .retrieve()
                .bodyToMono(ShippingResponse.class)
                .block();

        if (shippingResponse == null) {
            throw new RuntimeException("Failed to retrieve shipping response from USPS");
        }

        return shippingResponse;
    }
}
