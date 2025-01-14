package com.designmyecon.shipping.Shipping.model.dto;

import com.designmyecon.shipping.Shipping.model.enums.*;

public class USPSPricingRequest {
    private String originZIPCode;
    private String destinationZIPCode;
    private double weight;
    private double length;
    private double width;
    private double height;
    private MailClass mailClass;
    private ProcessingCategory processingCategory;
    private RateIndicator rateIndicator;
    private DestinationEntryFacilityType destinationEntryFacilityType;
    private String priceType;
    private String mailingDate;
    private String accountType;
    private String accountNumber;

    public String getOriginZIPCode() {
        return originZIPCode;
    }

    public void setOriginZIPCode(String originZIPCode) {
        this.originZIPCode = originZIPCode;
    }

    public String getDestinationZIPCode() {
        return destinationZIPCode;
    }

    public void setDestinationZIPCode(String destinationZIPCode) {
        this.destinationZIPCode = destinationZIPCode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public MailClass getMailClass() {
        return mailClass;
    }

    public void setMailClass(MailClass mailClass) {
        this.mailClass = mailClass;
    }

    public ProcessingCategory getProcessingCategory() {
        return processingCategory;
    }

    public void setProcessingCategory(ProcessingCategory processingCategory) {
        this.processingCategory = processingCategory;
    }

    public RateIndicator getRateIndicator() {
        return rateIndicator;
    }

    public void setRateIndicator(RateIndicator rateIndicator) {
        this.rateIndicator = rateIndicator;
    }

    public DestinationEntryFacilityType getDestinationEntryFacilityType() {
        return destinationEntryFacilityType;
    }

    public void setDestinationEntryFacilityType(DestinationEntryFacilityType destinationEntryFacilityType) {
        this.destinationEntryFacilityType = destinationEntryFacilityType;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getMailingDate() {
        return mailingDate;
    }

    public void setMailingDate(String mailingDate) {
        this.mailingDate = mailingDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
