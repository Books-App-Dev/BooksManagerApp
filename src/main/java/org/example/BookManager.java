package org.example;

import org.example.util.Color;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BookManager {
    //attributes
    private ArrayList<Book> bookList = new ArrayList<Book>();

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

    public void createBook(String scISBN, String scAuthor, String scTitle) {

        validInput(scISBN, scAuthor, scTitle);
        Book book = new Book(scISBN, scAuthor, scTitle);
        bookList.add(book);
    }

    private void validInput(String scISBN, String scAuthor, String scTitle) {
        if (bookList.stream().anyMatch(book -> book.getIsbn().equals(scISBN))) {
            throw new IllegalArgumentException(Color.RED + "Un libro ya existe con este ISBN" + Color.RESET);
        }
        if (!isValidISBN(scISBN) || scISBN.isEmpty() || scISBN.isBlank()) {
            throw new IllegalArgumentException(Color.RED + "El formato de ISBN no es válido (ejemplo correcto: A123) o campo está vacío" + Color.RESET);
        }
        if (scAuthor.isEmpty() || scTitle.isEmpty() ||
                scAuthor.isBlank() || scTitle.isBlank()) {
            throw new NullPointerException(Color.RED + "Rellena todos los campos!" + Color.RESET);
        }
    }

    public void deleteByIsbn(String isbnToDelete) {
        boolean remove = bookList.removeIf(book -> book.getIsbn().equals(isbnToDelete));
        if (!remove) {
            throw new NoSuchElementException("No se encontró ningún libro con este ISBN: " + isbnToDelete);
        }
    }

    public ArrayList<Book> getAllBooks() {
        return bookList;
    }
}