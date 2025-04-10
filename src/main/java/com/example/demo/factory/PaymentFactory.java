package com.example.demo.factory;


import com.example.demo.model.Payment;
import java.util.Map;

public interface PaymentFactory {
    Payment createPayment(Map<String, Object> datos);
}
