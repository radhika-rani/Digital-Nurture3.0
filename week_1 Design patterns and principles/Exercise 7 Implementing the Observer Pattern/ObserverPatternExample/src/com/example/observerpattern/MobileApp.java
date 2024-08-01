package com.example.observerpattern;

public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void update(Stock stock) {
        if (stock instanceof StockMarket) {
            StockMarket stockMarket = (StockMarket) stock;
            System.out.println("Mobile App (" + appName + "): " + stockMarket.getStockName() + " price updated to $" + stockMarket.getPrice());
        } else {
            System.out.println("Mobile App (" + appName + "): Stock type not recognized.");
        }
    }
}