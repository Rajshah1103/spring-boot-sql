package com.example.book_manager.service;

import com.example.book_manager.dto.BookRequest;
import com.example.book_manager.dto.BookResponse;
import com.example.book_manager.exception.BookNotFoundException;
import com.example.book_manager.mapper.BookMapper;
import com.example.book_manager.model.Book;
import com.example.book_manager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public  BookService (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook (BookRequest request) {
        Book book = BookMapper.toEntity(request);
        Book saved = bookRepository.save(book);
        return BookMapper.toResponse(saved);
    }

    public List<BookResponse> getAllBooks () {
        return bookRepository.findAll().stream().map(BookMapper::toResponse).collect(Collectors.toList());
    }

    public BookResponse getBookById (Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return BookMapper.toResponse(book);
    }

    public BookResponse updateBookById (Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        BookMapper.updateEntity(book, request);
        Book updated = bookRepository.save(book);
        return  BookMapper.toResponse(updated);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
    }
}
