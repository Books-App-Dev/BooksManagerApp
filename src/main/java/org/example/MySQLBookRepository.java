package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MySQLBookRepository implements BookRepository {

    //CRUD
    @Override
    public void save(Book book) {
        //CREATE a BOOK IN DATABASE
        book.getIsbn();
        String sql = "INSERT INTO libros (isbn, title,author) VALUES ('%s', '%s', '%s')"
                .formatted(book.getIsbn(), book.getTitulo(), book.getAutor());


        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM libros";
        List<Book> bookList = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

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
    public Optional<Book> findByIsbn(String isbn)  {
        String sql = "SELECT * FROM libros WHERE isbn='%s'".formatted(isbn);

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

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
        String sql = "DELETE FROM libros WHERE isbn = '%s'".formatted(isbn);

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
