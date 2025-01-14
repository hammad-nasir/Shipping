package com.designmyecon.shipping.Shipping.controller;

import com.designmyecon.shipping.Shipping.model.dto.TrackingUpdateRequest;
import com.designmyecon.shipping.Shipping.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class TrackingWebhookController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping("/usps")
    public ResponseEntity<String> handleUSPSTrackingUpdate(@RequestBody TrackingUpdateRequest updateRequest) {
        trackingService.processTrackingUpdate(updateRequest);
        return ResponseEntity.ok("Received");
    }
}
