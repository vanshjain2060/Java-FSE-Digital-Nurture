package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor Injection");
    }

    // Setter for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection");
    }

    public void display() {
        bookRepository.displayBooks();
    }

    public void addBook(String name) {
        System.out.println("Adding book...");
        bookRepository.saveBook(name);
    }
}
