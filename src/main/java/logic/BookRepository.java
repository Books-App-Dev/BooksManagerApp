package logic;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    //CRUD
    void save(Book book);

    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
