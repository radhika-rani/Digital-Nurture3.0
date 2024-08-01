package com.company;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        // Add Employees
        manager.addEmployee(new Employee(1, "John Doe", "Developer", 60000));
        manager.addEmployee(new Employee(2, "Jane Smith", "Manager", 80000));
        manager.addEmployee(new Employee(3, "Alice Johnson", "Designer", 55000));

        // Traverse Employees
        System.out.println("All Employees:");
        manager.traverseEmployees();

        // Search for an Employee
        System.out.println("\nSearching for Employee ID 2:");
        Employee employee = manager.searchEmployee(2);
        System.out.println(employee != null ? employee : "Employee not found.");

        // Delete an Employee
        System.out.println("\nDeleting Employee ID 2:");
        manager.deleteEmployee(2);
        System.out.println("Employees after deletion:");
        manager.traverseEmployees();
    }
}
