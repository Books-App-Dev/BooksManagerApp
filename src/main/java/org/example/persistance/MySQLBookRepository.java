package org.example.persistance;

import org.example.logic.Book;
import org.example.logic.BookRepository;
import org.example.config.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;

public class MySQLBookRepository implements BookRepository {

    @Override
    public void save(Book book) {
        book.getIsbn();
        String sql = "INSERT INTO libros (isbn, title,author) VALUES (?, ?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitulo());
            statement.setString(3, book.getAutor());

            statement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM libros";
        List<Book> bookList = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet res = statement.executeQuery()) {

            while (res.next()) {
                String isbn = res.getString("isbn");
                String title = res.getString("title");
                String author = res.getString("author");

                Book book = new Book(isbn, title, author);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookList;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = "SELECT * FROM libros WHERE isbn=?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, isbn);
            ResultSet res = statement.executeQuery();

            if (res.next()) {
                Book book = new Book(res.getString("isbn"),
                        res.getString("title"),
                        res.getString("author"));

                return Optional.of(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void deleteByIsbn(String isbn) {
        String sql = "DELETE FROM libros WHERE isbn = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, isbn);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
