package com.ecommerce;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0)
        };

        // Bubble Sort Test
        System.out.println("Orders before Bubble Sort:");
        printOrders(orders);
        SortingUtil.bubbleSort(orders);
        System.out.println("Orders after Bubble Sort:");
        printOrders(orders);

        // Reinitialize orders for Quick Sort Test
        orders = new Order[] {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0)
        };

        // Quick Sort Test
        System.out.println("Orders before Quick Sort:");
        printOrders(orders);
        SortingUtil.quickSort(orders, 0, orders.length - 1);
        System.out.println("Orders after Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}
