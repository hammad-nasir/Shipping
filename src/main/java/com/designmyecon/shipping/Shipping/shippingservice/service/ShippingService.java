package com.designmyecon.shipping.Shipping.shippingservice.service;

import com.designmyecon.shipping.Shipping.model.dto.ShippingRequest;
import com.designmyecon.shipping.Shipping.model.dto.ShippingResponse;

public interface ShippingService {
    ShippingResponse calculateShipping(ShippingRequest request);
}
