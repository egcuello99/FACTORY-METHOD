package com.example.demo.factory;

import com.example.demo.model.CreditCardPayment;
import com.example.demo.model.Payment;

import java.util.Map;

public class CreditCardFactory implements PaymentFactory {

    @Override
    public Payment createPayment(Map<String, Object> datos) {
        String numero = (String) datos.get("numero");
        String cvv = (String) datos.get("cvv");
        String expiracion = (String) datos.get("expiracion");

        return new CreditCardPayment(numero, cvv, expiracion);
    }
}
