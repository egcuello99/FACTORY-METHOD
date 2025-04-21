package com.example.demo.notifications;import java.util.List;
import com.example.demo.model.Notification;

public class WhatsAppNotification implements Notification {
    private final String phoneNumber;
    private final String message;
    private final String mediaUrl;
    private final String caption;
    private final List<String> interactiveButtons;
    private final String language;

    private WhatsAppNotification(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.message = builder.message;
        this.mediaUrl = builder.mediaUrl;
        this.caption = builder.caption;
        this.interactiveButtons = builder.interactiveButtons;
        this.language = builder.language;
    }

    @Override
    public void send() {
        System.out.println("Enviando mensaje de WhatsApp a: " + phoneNumber);
        // Implementación real del envío
    }

    public static class Builder {
        // Campos obligatorios
        private final String phoneNumber;
        private final String message;
        
        // Campos opcionales
        private String mediaUrl = null;
        private String caption = null;
        private List<String> interactiveButtons = List.of();
        private String language = "es";

        public Builder(String phoneNumber, String message) {
            this.phoneNumber = phoneNumber;
            this.message = message;
        }

        public Builder mediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public Builder interactiveButtons(List<String> interactiveButtons) {
            this.interactiveButtons = interactiveButtons;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public WhatsAppNotification build() {
            return new WhatsAppNotification(this);
        }
    }
}