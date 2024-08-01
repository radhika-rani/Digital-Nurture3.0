package com.inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product product1 = new Product(1, "Laptop", 10, 1500.00);
        Product product2 = new Product(2, "Smartphone", 20, 800.00);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Displaying products
        System.out.println("Initial Inventory:");
        inventory.displayProducts();

        // Updating a product
        product1.setPrice(1400.00);
        inventory.updateProduct(product1);

        // Displaying products after update
        System.out.println("\nInventory after updating the Laptop price:");
        inventory.displayProducts();

        // Deleting a product
        inventory.deleteProduct(2);

        // Displaying products after deletion
        System.out.println("\nInventory after deleting the Smartphone:");
        inventory.displayProducts();
    }
}
