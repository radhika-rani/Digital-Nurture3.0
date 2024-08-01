package com.example.adapters;

import com.example.payment.PaymentProcessor;
import com.example.paymentgateways.PayPalPaymentGateway;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway payPalPaymentGateway;

    public PayPalAdapter() {
        this.payPalPaymentGateway = new PayPalPaymentGateway();
    }

    @Override
    public void processPayment(double amount) {
        payPalPaymentGateway.makePayment(amount);
    }
}
