package org.example;
import org.example.util.Color;
import java.util.ArrayList;

public class BookManager {
    //attributes
    public ArrayList<Book> bookList = new ArrayList<Book>();

    //constructor
    public BookManager() {
    }

    //methods
    /**
     * Método que esta comprobando formato de ISBN
     * @param isbn pasamos datos que recibimos de usuario
     * @return true o false
     */
    private boolean isValidISBN(String isbn) {
        return isbn.matches("[A-Z]\\d{3}");
    }

    public void createBook(String scISBN, String scAuthor, String scTitle, App app) {

        if (bookList.stream().anyMatch(book -> book.getIsbn().equals(scISBN))) {
            throw new IllegalArgumentException(Color.RED + "Un libro ya existe con este ISBN" + Color.RESET);
        }
        if (!isValidISBN(scISBN)) {
            throw new IllegalArgumentException(Color.RED + "El formato de ISBN no es valido (ejemplo correcto: A123)" + Color.RESET);
        }
        if (scISBN.isEmpty() || scAuthor.isEmpty() || scTitle.isEmpty() ||
                scISBN.isBlank() || scAuthor.isBlank() || scTitle.isBlank()) {
            throw new NullPointerException(Color.RED + "Rellena todos los campos" + Color.RESET);
        }
        Book book = new Book(scISBN, scAuthor, scTitle);
        bookList.add(book);
    }
}