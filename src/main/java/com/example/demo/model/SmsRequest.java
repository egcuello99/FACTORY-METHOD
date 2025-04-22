package com.example.demo.model;

public class SmsRequest {
    private String phoneNumber;
    private String message;
    private String senderId;
    private Boolean deliveryReportRequired;

    // Getters y setters
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public Boolean getDeliveryReportRequired() { return deliveryReportRequired; }
    public void setDeliveryReportRequired(Boolean deliveryReportRequired) { this.deliveryReportRequired = deliveryReportRequired; }
}
