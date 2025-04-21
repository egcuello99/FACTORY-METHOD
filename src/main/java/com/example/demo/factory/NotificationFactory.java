package com.example.demo.factory;

import com.example.demo.model.Notification;
import com.example.demo.notifications.EmailNotification;
import com.example.demo.notifications.PushNotification;
import com.example.demo.notifications.SMSNotification;
import com.example.demo.notifications.WhatsAppNotification;

public class NotificationFactory {
    public static Notification createEmailNotification(EmailNotification.Builder builder) {
        return builder.build();
    }

    public static Notification createSMSNotification(SMSNotification.Builder builder) {
        return builder.build();
    }

    public static Notification createPushNotification(PushNotification.Builder builder) {
        return builder.build();
    }

    public static Notification createWhatsAppNotification(WhatsAppNotification.Builder builder) {
        return builder.build();
    }
}