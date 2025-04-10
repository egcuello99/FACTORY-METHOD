package com.example.demo.model;

public class CreditCardPayment implements Payment {

    private String cardNumber;
    private String cvv;
    private String expiry;

    public CreditCardPayment(String cardNumber, String cvv, String expiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    @Override
    public String process(double amount) {
        return "Pago con tarjeta " + cardNumber + " (expira " + expiry + "): $" + amount;
    }
}
