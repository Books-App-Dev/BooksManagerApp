package org.example;

import org.example.util.Color;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookConsoleView {
    private final BookManager bookManager;
    private final BookRepository inMemoryRepository;
    private final BookRepository mySQLRepository;
    Scanner scanner = new Scanner(System.in);

    public BookConsoleView() {
       this.bookManager  = new BookManager();
       this.inMemoryRepository = new InMemoryBookRepository();
       this.mySQLRepository = new MySQLBookRepository();
    }

    public void printMenu() {

        System.out.println(Color.CYAN + "\nGestor de Libros Técnicos de Programación\n" + Color.RESET);
        String[] menu = {
                "1. Añadir libro",
                "2. Ver todos los libros",
                "3. Eliminar libro",
                "4. Cambiar repositorio",
                "5. Salir"
        };

        byte option = 0;
        while (option != 5) {

            System.out.println(Color.GREEN + " **** MENU ****" + Color.RESET); // Estoy cambiando color a verde
            for (String item : menu) {
                System.out.println(item);
            }
            System.out.println(Color.YELLOW + "\nSeleccione una opción, introduce un número de 1 a 5:" + Color.RESET);
            String input = scanner.nextLine();

            try {
                option = Byte.parseByte(input);
            } catch (Exception ex) {
                System.out.println("Eso no es un número, introduce un número de [1-5]");
                continue;
            }

            if (option < 1 || option > 5) {
                System.out.println("Introduce un número de [1-5]");
                continue;
            }
            optionSelector(option);

        }
    }

    private void optionSelector(byte option) {
        if (option == 1) this.printAddBookMenu();
        if (option == 2) this.printBookList();
        if (option == 3) this.printRemoveBookMenu();
        if (option == 4) this.printChangeRepository();
    }

    // option 1
    private void printAddBookMenu() {

        System.out.println("Ingrese el título: ");
        String scTitle = scanner.nextLine();

        System.out.println("Ingrese el autor: ");
        String scAuthor = scanner.nextLine();

        System.out.println("Ingrese el ISBN (una letra seguida de tres números, por ejemplo, A123): ");
        String scISBN = scanner.nextLine().toUpperCase();

        try {
            this.bookManager.createBook(scISBN, scAuthor, scTitle);
            System.out.println("El libro ha sido añadido con éxito!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Option 2
    private void printBookList() {

        List<Book> bookList = bookManager.getAllBooks();
        try {
            for (Book book : bookList) {
                System.out.println(book.infoLibros());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (bookList.isEmpty()) {
            System.out.println("No hay libros en la colección.");
        }
    }

    //Option 3
    private void printRemoveBookMenu() {
        System.out.println("Introduce el ISBN del libro que quieres borrar: ");
        String isbnToDelete = scanner.nextLine().toUpperCase();

        try {
            this.bookManager.deleteByIsbn(isbnToDelete);
            System.out.println("Se ha eliminado el libro: " + isbnToDelete);
        } catch (Exception ex) {
            System.out.println(Color.RED + ex.getMessage() + Color.RESET);
        }
    }

    //Option 4
    private void printChangeRepository(){
        System.out.println("Seleccione el tipo de repositorio: ");
        System.out.println("1. Memoria");
        System.out.println("2. Base de datos MySQL");
        System.out.println("Seleccione una opción: ");

        String optionRepository = scanner.nextLine();

        if(optionRepository.equals("1")){
            bookManager.changeRepository(inMemoryRepository);
            System.out.println("Se cambió a repositorio de memoria");
        }
        if(optionRepository.equals("2")){
            bookManager.changeRepository(mySQLRepository);
            System.out.println("Se cambió a repositorio de base de datos MySQL");
        }
    }
}

