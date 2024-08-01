package com.example.proxypattern;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
        // Simulate loading an image from a remote server
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
