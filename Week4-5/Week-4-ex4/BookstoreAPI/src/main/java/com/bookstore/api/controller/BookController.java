package com.bookstore.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.bookstore.api.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    // GET a book by ID (path variable)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
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
    // POST a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.setId((long) (bookList.size() + 1)); // Temporary ID generation
        bookList.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // PUT to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPrice(updatedBook.getPrice());
                    book.setIsbn(updatedBook.getIsbn());
                    return new ResponseEntity<>(book, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = bookList.removeIf(book -> book.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
