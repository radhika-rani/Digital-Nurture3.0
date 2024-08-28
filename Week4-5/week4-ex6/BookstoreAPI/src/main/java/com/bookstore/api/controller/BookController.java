package com.bookstore.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookstore.api.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    // GET a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        
        return book.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET books by filtering (Query Parameters)
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<Book> filteredBooks = bookList;

        // Filter by title if present
        if (title != null && !title.isEmpty()) {
            filteredBooks = filteredBooks.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .toList();
        }

        // Filter by author if present
        if (author != null && !author.isEmpty()) {
            filteredBooks = filteredBooks.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .toList();
        }

        return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
    }

    // POST endpoint to create a new book with custom headers
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.setId((long) (bookList.size() + 1));  // Generate a new ID
        bookList.add(book);

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Creation", "Book successfully created");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    // PUT to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> existingBookOpt = bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();

        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());

            return new ResponseEntity<>(existingBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE a book with custom response status
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Return 204 No Content if successful
    public void deleteBook(@PathVariable Long id) {
        boolean removed = bookList.removeIf(book -> book.getId().equals(id));
        if (!removed) {
            throw new BookNotFoundException(); // Custom exception if book not found
        }
    }

    // Custom exception for book not found
    @ResponseStatus(HttpStatus.NOT_FOUND) // Return 404 Not Found
    @ExceptionHandler(BookNotFoundException.class)
    public void handleBookNotFound() {
        // This method is intentionally left empty
    }

    // Custom exception for book not found
    public static class BookNotFoundException extends RuntimeException {}
}
