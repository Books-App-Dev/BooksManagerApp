package org.example;

import org.example.util.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    @Override
    public void save(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteByIsbn(String isbn) {
        bookList.removeIf(book -> book.getIsbn().equals(isbn));
    }
}

