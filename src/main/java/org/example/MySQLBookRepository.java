package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySQLBookRepository {

    //CRUD
    public void save(Book book) {
        //CREATE a BOOK IN DATABASE
        book.getIsbn();
        String sql = "INSERT INTO libros (isbn, title,author) VALUES ('%s', '%s', '%s')"
                .formatted( book.getIsbn(), book.getTitulo(), book.getAutor());


        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    public List<Book> findAll() throws SQLException {
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

                Book book = new Book (isbn, title, author);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookList;
    }
}
