package com.example.observerpattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("TechCorp");

        Observer mobileApp = new MobileApp("StockAlert");
        Observer webApp = new WebApp("MarketWatch");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(150.75);
        stockMarket.setPrice(155.00);
    }
}
