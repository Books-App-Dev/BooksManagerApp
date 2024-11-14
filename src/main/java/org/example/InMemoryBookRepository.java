package org.example;

import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository{

    @Override
    public void save(Book book) {
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public void deleteByIsbn(String isbn) {

    }
}
