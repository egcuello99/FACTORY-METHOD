package com.example.demo.factory;

import com.example.demo.model.PaypalPayment;
import com.example.demo.model.Payment;

import java.util.Map;

public class PaypalFactory implements PaymentFactory {

    @Override
    public Payment createPayment(Map<String, Object> datos) {
        String email = (String) datos.get("email");

        return new PaypalPayment(email);
    }
}
