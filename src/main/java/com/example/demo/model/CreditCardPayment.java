package com.example.demo.model;

public class CreditCardPayment implements Payment {
    @Override
    public String process(double amount) {
        return "Pago con tarjeta de crédito: $" + amount;
    }
}
