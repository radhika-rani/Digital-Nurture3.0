package com.example.test;

import com.example.product.Computer;

public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create a Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("ASUS ROG Strix")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .setCaseType("Mid Tower")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated Graphics")
                .setMotherboard("Gigabyte")
                .setPowerSupply("500W")
                .setCoolingSystem("Air Cooling")
                .setCaseType("Mini Tower")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
