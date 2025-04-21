package com.example.demo.controllers;

import com.example.demo.PDFReport.PDFReport;
import com.example.demo.PDFReport.Theme;
import com.example.demo.factory.*;
import com.example.demo.model.Payment;
import com.example.demo.notifications.EmailNotification;
import com.example.demo.model.Notification;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @PostMapping
    public Map<String, Object> procesarPago(@RequestParam String metodo, @RequestParam double monto) {
        PaymentFactory factory;
        Map<String, Object> response = new LinkedHashMap<>();

        switch (metodo.toLowerCase()) {
            case "tarjeta":
                factory = new CreditCardFactory();
                break;
            case "paypal":
                factory = new PaypalFactory();
                break;
            default:
                response.put("error", "Método de pago no soportado");
                return response;
        }

        Payment payment = factory.createPayment();
        payment.process(monto); // Si devuelve void
        response.put("pago", "Pago procesado con " + metodo + ", monto: " + monto);

        Notification email = new EmailNotification.Builder("cliente@example.com", "Confirmación de Pago",
                "Su pago ha sido procesado")
                .cc(List.of("soporte@example.com"))
                .priority("alta")
                .build();
        email.send(); // Si devuelve void
        response.put("email", "Email enviado exitosamente");

        PDFReport customReport = new PDFReport.Builder()
                .title("Reporte Especial")
                .includeLogo(true)
                .theme(Theme.DARK)
                .footerMessage("Versión premium")
                .includePaymentDetails(true)
                .includeUserInfo(false)
                .build();
        customReport.generate(); // Si devuelve void
        response.put("reporte", "Reporte PDF generado exitosamente");

        return response;
    }
}
