package com.FinancialForecasting;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double principal, double rate, int years) {
        // Base case: no years left to apply growth
        if (years == 0) {
            return principal;
        } else {
            // Recursive case: apply growth and call method for next year
            return calculateFutureValue(principal, rate, years - 1) * (1 + rate);
        }
    }

    public static void main(String[] args) {
        double principal = 1000.0; // Initial amount
        double rate = 0.05; // Growth rate (5%)
        int years = 10; // Number of years

        double futureValue = calculateFutureValue(principal, rate, years);
        System.out.printf("Future Value: %.15f\n", futureValue);
    }
}
