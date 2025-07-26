package com.example.book_manager.dto;

import java.time.LocalDate;

public class BookResponse {

    private long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private String genre;
    private String description;

    // Constructor
    public BookResponse(Long id, String title, String author, LocalDate publishedDate, String genre, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }
}
