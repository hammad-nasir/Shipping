package com.designmyecon.shipping.Shipping.shippingservice.service;

import com.designmyecon.shipping.Shipping.model.dto.ShippingRequest;
import com.designmyecon.shipping.Shipping.model.dto.ShippingResponse;

public interface CarrierStrategy {
    String getCarrierName();  // Each strategy returns its identifier
    ShippingResponse calculate(ShippingRequest request);
}
