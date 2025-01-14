package com.designmyecon.shipping.Shipping.model.dto;

import lombok.Data;

@Data
public class ShippingResponse {
    public double getTotalBasePrice() {
        return totalBasePrice;
    }

    public void setTotalBasePrice(double totalBasePrice) {
        this.totalBasePrice = totalBasePrice;
    }

    private double totalBasePrice;
}