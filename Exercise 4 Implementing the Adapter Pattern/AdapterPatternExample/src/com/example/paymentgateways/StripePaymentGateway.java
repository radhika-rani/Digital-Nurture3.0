package com.example.paymentgateways;

public class StripePaymentGateway {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
