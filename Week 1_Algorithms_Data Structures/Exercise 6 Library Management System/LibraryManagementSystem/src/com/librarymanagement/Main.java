package com.librarymanagement;

public class Main {
    public static void main(String[] args) {
        // Create sample books
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Moby Dick", "Herman Melville")
        };

        LibraryManager manager = new LibraryManager(books);

        // Test Linear Search
        System.out.println("Linear Search Result:");
        Book book = manager.linearSearch("1984");
        System.out.println(book != null ? book : "Book not found.");

        // Test Binary Search
        System.out.println("\nBinary Search Result:");
        book = manager.binarySearch("To Kill a Mockingbird");
        System.out.println(book != null ? book : "Book not found.");
    }
}
