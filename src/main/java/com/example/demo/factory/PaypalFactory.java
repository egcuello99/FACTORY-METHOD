package com.example.demo.factory;

import com.example.demo.model.PaypalPayment;
import com.example.demo.model.Payment;

public class PaypalFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PaypalPayment();
    }
}
