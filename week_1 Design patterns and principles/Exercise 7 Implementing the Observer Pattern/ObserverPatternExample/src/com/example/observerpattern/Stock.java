package com.example.observerpattern;

public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
    String getStockName();
    double getPrice();
}
