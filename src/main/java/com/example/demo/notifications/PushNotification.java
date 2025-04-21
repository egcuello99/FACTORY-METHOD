package com.example.demo.notifications;
import com.example.demo.model.Notification;

public class PushNotification implements Notification {
    private final String deviceToken;
    private final String title;
    private final String message;
    private final String imageUrl;
    private final String clickAction;
    private final String priority;

    private PushNotification(Builder builder) {
        this.deviceToken = builder.deviceToken;
        this.title = builder.title;
        this.message = builder.message;
        this.imageUrl = builder.imageUrl;
        this.clickAction = builder.clickAction;
        this.priority = builder.priority;
    }

    @Override
    public void send() {
        System.out.println("Enviando notificación PUSH a dispositivo: " + deviceToken);
        // Implementación real del envío
    }

    public static class Builder {
        // Campos obligatorios
        private final String deviceToken;
        private final String title;
        private final String message;
        
        // Campos opcionales
        private String imageUrl = null;
        private String clickAction = null;
        private String priority = "normal";

        public Builder(String deviceToken, String title, String message) {
            this.deviceToken = deviceToken;
            this.title = title;
            this.message = message;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder clickAction(String clickAction) {
            this.clickAction = clickAction;
            return this;
        }

        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public PushNotification build() {
            return new PushNotification(this);
        }
    }
}
