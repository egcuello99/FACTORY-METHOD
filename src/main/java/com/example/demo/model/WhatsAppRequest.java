package com.example.demo.model;

public class WhatsAppRequest {
    private String phoneNumber;
    private String message;
    private String mediaUrl;
    private String caption;

    public WhatsAppRequest() {
    }

    public WhatsAppRequest(String phoneNumber, String message, String mediaUrl, String caption) {
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.mediaUrl = mediaUrl;
        this.caption = caption;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}


