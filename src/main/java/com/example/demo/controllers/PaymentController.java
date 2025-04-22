
package com.example.demo.controllers;
import com.example.demo.model.PagoRequest;
import com.example.demo.PDFReport.PDFReport;
import com.example.demo.PDFReport.Theme;
import com.example.demo.factory.*;
import com.example.demo.model.Payment;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @PostMapping
    public Map<String, Object> procesarPago(@RequestBody PagoRequest pagoRequest) {
        String metodo = pagoRequest.getMetodo();
        double monto = pagoRequest.getMonto();

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
        payment.process(monto);
        response.put("pago", "Pago procesado con " + metodo + ", monto: " + monto);

        PDFReport customReport = new PDFReport.Builder()
                .title("Comprobante de Pago - " + metodo)
                .includeLogo(true)
                .theme(Theme.LIGHT)
                .footerMessage("Gracias por su compra")
                .includePaymentDetails(true)
                .includeUserInfo(true)
                .build();
        customReport.generate();
        response.put("reporte", "Reporte PDF generado exitosamente");
        return response;
    }
}
