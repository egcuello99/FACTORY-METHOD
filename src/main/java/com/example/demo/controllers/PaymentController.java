package com.example.demo.controllers;

import com.example.demo.factory.*;
import com.example.demo.model.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @PostMapping
    public String procesarPago(@RequestBody Map<String, Object> datos) {
        String metodo = (String) datos.get("metodo");
        double monto = Double.parseDouble(datos.get("monto").toString());

        PaymentFactory factory;

        switch (metodo.toLowerCase()) {
            case "tarjeta":
                factory = new CreditCardFactory();
                break;
            case "paypal":
                factory = new PaypalFactory();
                break;
            case "transferencia":
                factory = new BankTransferFactory();
                break;
            default:
                return "Método de pago no soportado";
        }

        Payment payment = factory.createPayment(datos);
        return payment.process(monto);
    }
}
