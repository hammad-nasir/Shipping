package com.designmyecon.shipping.Shipping.shippingservice.service.impl;

import com.designmyecon.shipping.Shipping.model.dto.ShippingRequest;
import com.designmyecon.shipping.Shipping.model.dto.ShippingResponse;
import com.designmyecon.shipping.Shipping.shippingservice.service.CarrierStrategy;
import com.designmyecon.shipping.Shipping.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShippingServiceImpl implements ShippingService {

    private final Map<String, CarrierStrategy> strategyMap;

    @Autowired
    public ShippingServiceImpl(List<CarrierStrategy> strategies) {
        // Build a map of carrier name to strategy for quick lookup
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(CarrierStrategy::getCarrierName, strategy -> strategy));
    }

    @Override
    public ShippingResponse calculateShipping(ShippingRequest request) {
        String carrier = request.getCarrier();
        CarrierStrategy strategy = strategyMap.get(carrier);

        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported carrier: " + carrier);
        }

        return strategy.calculate(request);
    }
}