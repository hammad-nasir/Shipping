package com.designmyecon.shipping.Shipping.service.impl;

import com.designmyecon.shipping.Shipping.model.dto.TrackingUpdateRequest;
import com.designmyecon.shipping.Shipping.model.entity.TrackingEvent;
import com.designmyecon.shipping.Shipping.repository.TrackingEventRepository;
import com.designmyecon.shipping.Shipping.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingEventRepository trackingEventRepository;

    @Override
    public void processTrackingUpdate(TrackingUpdateRequest updateRequest) {
        // Create a new TrackingEvent entity and save it to the database.
        TrackingEvent event = new TrackingEvent();
        event.setTrackingNumber(updateRequest.getTrackingNumber());
        event.setStatus(updateRequest.getStatus());
        event.setLocation(updateRequest.getLocation());
        event.setTimestamp(LocalDateTime.parse(updateRequest.getTimestamp())); // parse accordingly
        trackingEventRepository.save(event);
    }
}
