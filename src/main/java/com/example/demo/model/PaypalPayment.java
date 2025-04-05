package com.example.demo.model;


public class PaypalPayment implements Payment {
    @Override
    public String process(double amount) {
        return "Pago con PayPal: $" + amount;
    }
}
