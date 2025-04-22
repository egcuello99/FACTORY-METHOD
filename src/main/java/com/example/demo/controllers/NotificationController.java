package com.example.demo.controllers;

import com.example.demo.model.EmailNotificationRequest;
import com.example.demo.model.Notification;
import com.example.demo.model.PushNotificationRequest;
import com.example.demo.model.SmsRequest;
import com.example.demo.model.WhatsAppRequest;
import com.example.demo.notifications.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notificacion")
public class NotificationController {

    @PostMapping("/email")
    public Map<String, Object> enviarEmail(@RequestBody EmailNotificationRequest request) {

        EmailNotification.Builder builder = new EmailNotification.Builder(
                request.getTo(),
                request.getSubject(),
                request.getBody());

        if (request.getCc() != null)
            builder.cc(request.getCc());
        if (request.getBcc() != null)
            builder.bcc(request.getBcc());
        if (request.getPriority() != null)
            builder.priority(request.getPriority());

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/sms")
    public Map<String, Object> enviarSMS(@RequestBody SmsRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String message = request.getMessage();
        String senderId = request.getSenderId();
        Boolean deliveryReportRequired = request.getDeliveryReportRequired();

        if (phoneNumber == null || !phoneNumber.matches("\\+\\d+")) {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }

        SMSNotification.Builder builder = new SMSNotification.Builder(phoneNumber, message);

        if (senderId != null)
            builder.senderId(senderId);
        if (deliveryReportRequired != null)
            builder.deliveryReportRequired(deliveryReportRequired);

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/push")
    public Map<String, Object> enviarPush(@RequestBody PushNotificationRequest request) {

        PushNotification.Builder builder = new PushNotification.Builder(
                request.getDeviceToken(),
                request.getTitle(),
                request.getMessage());

        if (request.getImageUrl() != null)
            builder.imageUrl(request.getImageUrl());
        if (request.getPriority() != null)
            builder.priority(request.getPriority());

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/whatsapp")
    public Map<String, Object> enviarWhatsApp(@RequestBody WhatsAppRequest request) {

        String phoneNumber = request.getPhoneNumber();
        String message = request.getMessage();
        String mediaUrl = request.getMediaUrl();
        String caption = request.getCaption();

        if (phoneNumber == null || !phoneNumber.matches("\\+\\d+")) {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }

        WhatsAppNotification.Builder builder = new WhatsAppNotification.Builder(phoneNumber, message);

        if (mediaUrl != null)
            builder.mediaUrl(mediaUrl);
        if (caption != null)
            builder.caption(caption);

        return enviarNotificacion(builder.build());
    }

    private Map<String, Object> enviarNotificacion(Notification notification) {
        Map<String, Object> response = new LinkedHashMap<>();

        try {
            boolean enviado = notification.send();
            response.put("status", enviado ? "success" : "failed");
            response.put("sent", enviado);
            response.put("notificationType", notification.getClass().getSimpleName());

            if (!enviado) {
                response.put("message", "Error al enviar la notificación");
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            response.put("sent", false);
        }

        return response;
    }
}