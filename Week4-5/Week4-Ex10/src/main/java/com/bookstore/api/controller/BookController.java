package com.bookstore.api.controller;

import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.exception.BookNotFoundException;
import com.bookstore.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Retrieve all books with HATEOAS links and support for JSON and XML
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<EntityModel<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();

        return books.stream()
                .map(book -> {
                    Link selfLink = linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel();
                    Link allBooksLink = linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books");
                    return EntityModel.of(book, selfLink, allBooksLink);
                })
                .collect(Collectors.toList());
    }

    // Retrieve a single book by ID with HATEOAS links and support for JSON and XML
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EntityModel<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO book = bookService.getBookById(id);

        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        // Add HATEOAS links
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel();
        Link allBooksLink = linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books");

        return EntityModel.of(book, selfLink, allBooksLink);
    }

    // Create a new book
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EntityModel<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);

        // Add HATEOAS links
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(createdBook.getId())).withSelfRel();
        Link allBooksLink = linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books");

        return EntityModel.of(createdBook, selfLink, allBooksLink);
    }

    // Update an existing book
    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EntityModel<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);

        if (updatedBook == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        // Add HATEOAS links
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel();
        Link allBooksLink = linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books");

        return EntityModel.of(updatedBook, selfLink, allBooksLink);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
