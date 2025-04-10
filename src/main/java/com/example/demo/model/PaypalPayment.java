package com.example.demo.model;

public class PaypalPayment implements Payment {

    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public String process(double amount) {
        return "Pago con PayPal desde " + email + ": $" + amount;
    }
}
