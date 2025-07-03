package com.library.repository;

public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Book saved: " + bookName);
    }

    public void displayBooks() {
        System.out.println("Books fetched from repository...");
    }
}

