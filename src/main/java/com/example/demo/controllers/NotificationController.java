package com.example.demo.controllers;

import com.example.demo.model.Notification;
import com.example.demo.notifications.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notificacion")
public class NotificationController {

    @PostMapping("/email")
    public Map<String, Object> enviarEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) List<String> cc,
            @RequestParam(required = false) List<String> bcc,
            @RequestParam(required = false) String priority) {

        EmailNotification.Builder builder = new EmailNotification.Builder(to, subject, body);

        if (cc != null)
            builder.cc(cc);
        if (bcc != null)
            builder.bcc(bcc);
        if (priority != null)
            builder.priority(priority);

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/sms")
    public Map<String, Object> enviarSMS(
            @RequestParam String phoneNumber,
            @RequestParam String message,
            @RequestParam(required = false) String senderId,
            @RequestParam(required = false) Boolean deliveryReportRequired) {

        SMSNotification.Builder builder = new SMSNotification.Builder(phoneNumber, message);

        if (senderId != null)
            builder.senderId(senderId);
        if (deliveryReportRequired != null)
            builder.deliveryReportRequired(deliveryReportRequired);

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/push")
    public Map<String, Object> enviarPush(
            @RequestParam String deviceToken,
            @RequestParam String title,
            @RequestParam String message,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) String priority) {

        PushNotification.Builder builder = new PushNotification.Builder(deviceToken, title, message);

        if (imageUrl != null)
            builder.imageUrl(imageUrl);
        if (priority != null)
            builder.priority(priority);

        return enviarNotificacion(builder.build());
    }

    @PostMapping("/whatsapp")
    public Map<String, Object> enviarWhatsApp(
            @RequestParam String phoneNumber,
            @RequestParam String message,
            @RequestParam(required = false) String mediaUrl,
            @RequestParam(required = false) String caption) {

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