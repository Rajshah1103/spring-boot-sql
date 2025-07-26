package com.example.book_manager.controller;

import com.example.book_manager.dto.BookRequest;
import com.example.book_manager.dto.BookResponse;
import com.example.book_manager.model.Book;
import com.example.book_manager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public  BookController (BookService bookService) {
        this.bookService = bookService;
    }

    // create a book
    @PostMapping
    public ResponseEntity<BookResponse> createBook (@RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    // get al the books
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks () {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // get book by id
    @GetMapping("/{id}")
    public  ResponseEntity<BookResponse> getBookById (@PathVariable Long id) {
        return  ResponseEntity.ok(bookService.getBookById(id));
    }

    // Update book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.updateBookById(id, request));
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
