package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    //CRUD
    void save(Book book);

    List<Book> findAll() throws SQLException;

    Optional<Book> findByIsbn(String isbn) throws SQLException;

    void deleteByIsbn(String isbn);
}
