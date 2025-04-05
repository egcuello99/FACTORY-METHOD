package com.example.demo.factory;

import com.example.demo.model.CreditCardPayment;
import com.example.demo.model.Payment;

public class CreditCardFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
