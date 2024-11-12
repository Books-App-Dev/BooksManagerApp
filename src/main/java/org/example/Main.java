package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        //BookConsoleView nuestraApp = new BookConsoleView();
        //  nuestraApp.printMenu();
        // CASO DE USO: Guardar libro
        Book book = new Book("C233", "Clean Code", "Uncle Bob");
        MySQLBookRepository bookRepository = new MySQLBookRepository();
        bookRepository.save(book);

        List<Book> bookList = bookRepository.findAll();
        for (Book book1 : bookList) {
            System.out.println("El ISBN es " + book1.getIsbn());
            System.out.println("El libro es " + book1.getTitulo());
            System.out.println("El autor es " + book1.getAutor() + "\n");
        }

        Optional<Book> optionalBook = bookRepository.findByIsbn("C233");

        if (optionalBook.isPresent()) {
            Book book1 = optionalBook.get();
            System.out.println(book1);
        }

        if (optionalBook.isEmpty()) {
            System.out.println("El libro no existe.");
        }

    }
}


