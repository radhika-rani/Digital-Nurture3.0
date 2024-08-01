package com.example.test;

import com.example.adapters.PayPalAdapter;
import com.example.adapters.StripeAdapter;
import com.example.payment.PaymentProcessor;

public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter();
        payPalProcessor.processPayment(100.00);

        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment(200.00);
    }
}
