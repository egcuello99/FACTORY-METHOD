package com.example.demo.controllers;

import com.example.demo.factory.*;
import com.example.demo.model.Payment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @PostMapping
    public String procesarPago(@RequestParam String metodo, @RequestParam double monto) {
        PaymentFactory factory;

        switch (metodo.toLowerCase()) {
            case "tarjeta":
                factory = new CreditCardFactory();
                break;
            case "paypal":
                factory = new PaypalFactory();
                break;
            default:
                return "Método de pago no soportado";
        }

        Payment payment = factory.createPayment();
        return payment.process(monto);
    }
}
