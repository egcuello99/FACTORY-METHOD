package com.example.demo.factory;

import com.example.demo.model.BankTransferPayment;
import com.example.demo.model.Payment;

import java.util.Map;

public class BankTransferFactory implements PaymentFactory {

    @Override
    public Payment createPayment(Map<String, Object> datos) {
        String cuenta = (String) datos.get("cuenta");
        String banco = (String) datos.get("banco");

        return new BankTransferPayment(cuenta, banco);
    }
}
