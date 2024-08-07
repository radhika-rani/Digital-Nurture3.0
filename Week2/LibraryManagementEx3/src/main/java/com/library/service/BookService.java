package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to simulate book management
    public void manageBooks() {
        System.out.println("Managing books...");
        bookRepository.findAllBooks();
    }
}
