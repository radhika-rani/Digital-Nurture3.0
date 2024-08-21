package controller;

import model.Book;
import exception.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Constructor to add some default books
    public BookController() {
        books.add(new Book(1, "Effective Java", "Joshua Bloch", 450.00, "1234567890"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 500.00, "0987654321"));
    }

    // Get all books or filter by title or author
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {
        
        List<Book> filteredBooks = new ArrayList<>(books);
        
        if (title != null) {
            filteredBooks.removeIf(book -> !book.getTitle().equalsIgnoreCase(title));
        }
        
        if (author != null) {
            filteredBooks.removeIf(book -> !book.getAuthor().equalsIgnoreCase(author));
        }

        return ResponseEntity.ok(filteredBooks);
    }

    // Get a book by ID (Path Variable)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == id).findFirst();
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
    }

    // Add a new book (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        books.add(newBook);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book Created");
        
        return new ResponseEntity<>(newBook, headers, HttpStatus.CREATED);
    }

    // Update an existing book by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Optional<Book> existingBook = books.stream().filter(b -> b.getId() == id).findFirst();
        
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            bookToUpdate.setTitle(updatedBook.getTitle());
            bookToUpdate.setAuthor(updatedBook.getAuthor());
            bookToUpdate.setPrice(updatedBook.getPrice());
            bookToUpdate.setIsbn(updatedBook.getIsbn());
            
            return ResponseEntity.ok(bookToUpdate);
        } else {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
    }

    // Delete a book by ID (DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == id).findFirst();
        if (book.isPresent()) {
            books.remove(book.get());
        } else {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
    }
}
