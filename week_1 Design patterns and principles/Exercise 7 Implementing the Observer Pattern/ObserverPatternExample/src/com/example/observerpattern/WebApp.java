package com.example.observerpattern;

public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(Stock stock) {
        if (stock instanceof StockMarket) {
            StockMarket stockMarket = (StockMarket) stock;
            System.out.println("Web App (" + appName + "): " + stockMarket.getStockName() + " price updated to $" + stockMarket.getPrice());
        } else {
            System.out.println("Web App (" + appName + "): Stock type not recognized.");
        }
    }
}