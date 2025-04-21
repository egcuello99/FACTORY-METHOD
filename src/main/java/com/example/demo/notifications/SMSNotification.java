package com.example.demo.notifications;import java.time.LocalDateTime;

import com.example.demo.model.Notification;


public class SMSNotification implements Notification {
    private final String phoneNumber;
    private final String message;
    private final String senderId;
    private final boolean deliveryReportRequired;
    private final LocalDateTime scheduleTime;

    private SMSNotification(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.message = builder.message;
        this.senderId = builder.senderId;
        this.deliveryReportRequired = builder.deliveryReportRequired;
        this.scheduleTime = builder.scheduleTime;
    }

    @Override
    public void send() {
        System.out.println("Enviando SMS a: " + phoneNumber);
        // Implementación real del envío
    }

    public static class Builder {
        // Campos obligatorios
        private final String phoneNumber;
        private final String message;
        
        // Campos opcionales
        private String senderId = null;
        private boolean deliveryReportRequired = false;
        private LocalDateTime scheduleTime = null;

        public Builder(String phoneNumber, String message) {
            this.phoneNumber = phoneNumber;
            this.message = message;
        }

        public Builder senderId(String senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder deliveryReportRequired(boolean deliveryReportRequired) {
            this.deliveryReportRequired = deliveryReportRequired;
            return this;
        }

        public Builder scheduleTime(LocalDateTime scheduleTime) {
            this.scheduleTime = scheduleTime;
            return this;
        }

        public SMSNotification build() {
            return new SMSNotification(this);
        }
    }
}
