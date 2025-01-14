package com.designmyecon.shipping.Shipping.controller;

import com.designmyecon.shipping.Shipping.model.dto.ShippingRequest;
import com.designmyecon.shipping.Shipping.model.dto.ShippingResponse;
import com.designmyecon.shipping.Shipping.shippingservice.service.CarrierStrategy;
import com.designmyecon.shipping.Shipping.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ShippingResponse> calculateShipping(@RequestBody ShippingRequest request) {
        ShippingResponse response = shippingService.calculateShipping(request);
        return ResponseEntity.ok(response);
    }


}
