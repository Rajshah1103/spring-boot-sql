package com.example.book_manager.mapper;

import com.example.book_manager.dto.BookRequest;
import com.example.book_manager.dto.BookResponse;
import com.example.book_manager.model.Book;

public class BookMapper {

    public static Book toEntity(BookRequest request) {
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setGenre(request.getGenre());
        book.setPublishedDate(request.getPublishedDate());
        return book;
    }

    public static BookResponse toResponse (Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishedDate(),
                book.getGenre(),
                book.getDescription()
        );
    }

    public static void updateEntity(Book book, BookRequest request) {
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setGenre(request.getGenre());
        book.setDescription(request.getDescription());
    }
};
