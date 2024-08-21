package controller;

import model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // POST request to create a new book with custom status and headers
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Custom status code for POST request
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book);

        // Custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookstoreApp-Created");

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(book);
    }

    // GET request to fetch all books or filter by title and author with custom status and headers
    @GetMapping
    @ResponseStatus(HttpStatus.OK) // Custom status for GET
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) String author) {
        List<Book> filteredBooks = books;

        if (title != null && !title.isEmpty()) {
            filteredBooks = filteredBooks.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
        }

        if (author != null && !author.isEmpty()) {
            filteredBooks = filteredBooks.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
        }

        // Custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookstoreApp-Books");

        return ResponseEntity.ok().headers(headers).body(filteredBooks);
    }

    // GET request to fetch a book by ID with custom status for not found
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Custom status for found
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == id).findFirst();

        // Custom status for not found and custom headers
        return book.map(b -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Custom-Header", "BookstoreApp-Book-Found");
                    return ResponseEntity.ok().headers(headers).body(b);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("Custom-Header", "BookstoreApp-Book-Not-Found").build());
    }

    // PUT request to update a book
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == id) {
                updatedBook.setId(id);
                books.set(i, updatedBook);

                // Custom headers
                HttpHeaders headers = new HttpHeaders();
                headers.add("Custom-Header", "BookstoreApp-Book-Updated");

                return ResponseEntity.ok().headers(headers).body(updatedBook);
            }
        }

        // Custom headers for not found case
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("Custom-Header", "BookstoreApp-Book-Not-Found").build();
    }

    // DELETE request to delete a book with custom headers and 204 status
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Custom status for DELETE
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);

        // Custom headers for delete operation
        if (removed) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "BookstoreApp-Book-Deleted");

            return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Custom-Header", "BookstoreApp-Book-Not-Found").build();
        }
    }
}
