package com.example.strategypattern;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(250);

        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(150);
    }
}
