package com.designmyecon.shipping.Shipping.model.dto;

import com.designmyecon.shipping.Shipping.model.enums.MailClass;
import lombok.Data;

@Data
public class ShippingRequest {
    private String carrier;
    private Double weight;
    private String originZip;
    private String destinationZip;

    public MailClass getMailClass() {
        return mailClass;
    }

    public void setMailClass(MailClass mailClass) {
        this.mailClass = mailClass;
    }

    public String getDestinationZip() {
        return destinationZip;
    }

    public void setDestinationZip(String destinationZip) {
        this.destinationZip = destinationZip;
    }

    public String getOriginZip() {
        return originZip;
    }

    public void setOriginZip(String originZip) {
        this.originZip = originZip;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    private MailClass mailClass;
}
