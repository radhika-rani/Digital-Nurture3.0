package com.ecommerce;

public class SearchUtil {
    // Linear Search method
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product; // Return the product if found
            }
        }
        return null; // Return null if the product is not found
    }

    // Binary Search method
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid]; // Return the product if found
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1; // Continue search in the right half
            } else {
                right = mid - 1; // Continue search in the left half
            }
        }
        return null; // Return null if the product is not found
    }
}
