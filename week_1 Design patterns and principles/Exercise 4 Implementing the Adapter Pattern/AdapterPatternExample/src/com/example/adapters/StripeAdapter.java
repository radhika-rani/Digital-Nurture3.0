package com.example.adapters;

import com.example.payment.PaymentProcessor;
import com.example.paymentgateways.StripePaymentGateway;

public class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripePaymentGateway;

    public StripeAdapter() {
        this.stripePaymentGateway = new StripePaymentGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripePaymentGateway.pay(amount);
    }
}
