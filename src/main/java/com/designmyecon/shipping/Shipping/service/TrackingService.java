package com.designmyecon.shipping.Shipping.service;

import com.designmyecon.shipping.Shipping.model.dto.TrackingUpdateRequest;

public interface TrackingService {
    void processTrackingUpdate(TrackingUpdateRequest updateRequest);
}
