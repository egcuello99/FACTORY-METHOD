package com.example.demo.model;

public class BankTransferPayment implements Payment {
    private String cuenta;
    private String banco;

    public BankTransferPayment(String cuenta, String banco) {
        this.cuenta = cuenta;
        this.banco = banco;
    }

    @Override
    public String process(double amount) {
        return "Transferencia de $" + amount + " enviada a la cuenta " + cuenta + " del banco " + banco;
    }
}
