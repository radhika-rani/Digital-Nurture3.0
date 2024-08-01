package com.ecommerce;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances")
        };

        // Sorting products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Linear Search Test
        Product result = SearchUtil.linearSearch(products, 2);
        System.out.println("Linear Search Result: " + result);

        // Binary Search Test
        result = SearchUtil.binarySearch(products, 2);
        System.out.println("Binary Search Result: " + result);
    }
}
