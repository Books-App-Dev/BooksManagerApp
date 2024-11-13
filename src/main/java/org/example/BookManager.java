package org.example;

import org.example.util.Color;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookManager {
    //attributes
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private BookRepository bookRepository = new MySQLBookRepository();

    //constructor
    public BookManager() {
    }

    //methods

    /**
     * Método que esta comprobando formato de ISBN
     *
     * @param isbn pasamos datos que recibimos de usuario
     * @return true o false
     */
    private boolean isValidISBN(String isbn) {
        return isbn.matches("[A-Z]\\d{3}");
    }

    public void createBook(String scISBN, String scAuthor, String scTitle) throws SQLException {

        validInput(scISBN, scAuthor, scTitle);
        Book book = new Book(scISBN, scAuthor, scTitle);
        bookRepository.save(book);
    }

    private void validInput(String scISBN, String scAuthor, String scTitle) throws SQLException {
        Optional<Book> optionalBook = bookRepository.findByIsbn(scISBN);

        if (optionalBook.isPresent()) {
            throw new IllegalArgumentException(Color.RED + "Un libro ya existe con este ISBN" + Color.RESET);
        }
        if (!isValidISBN(scISBN) || scISBN.isEmpty() || scISBN.isBlank()) {
            throw new IllegalArgumentException(Color.RED + "El formato de ISBN no es válido (ejemplo correcto: A123) o campo está vacío" + Color.RESET);
        }
        if (scAuthor.isEmpty() || scTitle.isEmpty() ||
                scAuthor.isBlank() || scTitle.isBlank()) {
            throw new IllegalArgumentException(Color.RED + "Rellena todos los campos!" + Color.RESET);
        }
    }

    public void deleteByIsbn(String isbnToDelete) throws SQLException {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbnToDelete);
        bookRepository.deleteByIsbn(isbnToDelete);
        if (optionalBook.isEmpty()) {
            throw new NoSuchElementException("No se encontró ningún libro con este ISBN: " + isbnToDelete);
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookRepository.findAll();
    }
}
