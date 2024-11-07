package org.example;
import org.example.util.Color;
import java.util.Scanner;

public class App {
    final BookManager bookManager = new BookManager();
    Scanner scanner = new Scanner(System.in);

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
            System.out.println(Color.YELLOW + "\nSeleccione una opción, introduce un numero de 1 a 5:" + Color.RESET);
            String input = scanner.nextLine();

            try {
                option = Byte.parseByte(input);
            } catch (Exception ex) {
                System.out.println("Eso no es un numero, introduce un numero de [1-5]");
                continue;
            }

            if (option < 1 || option > 5) {
                System.out.println("Introduce un numero de [1-5]");
                continue;
            }
            optionSelector(option);
            System.out.println("\nHas elegido: " + menu[option - 1]);
        }

    }

    private void optionSelector(byte option) {
        if (option == 1) this.printAddBookMenu();
        if (option == 2) this.printBookList();
        if (option == 3) this.printRemoveBookMenu();
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
            this.bookManager.createBook(scISBN, scAuthor, scTitle, this);
            System.out.println("El libro ha sido añadido con éxito");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Option 2
    private void printBookList() {
        for (Book book : bookManager.bookList) {
            System.out.println(book.infoLibros());
        }
        if (bookManager.bookList.isEmpty()) {
            System.out.println("No hay libros en la colección.");
        }
    }
    //Option 3
    private void printRemoveBookMenu(){
        System.out.println("Introduce el ISBN del libro que quieres borrar: ");
        String isbnToDelete = scanner.nextLine().toUpperCase();
        this.deleteByIsbn (isbnToDelete);
        System.out.println("Se ha eliminado el libro: " + isbnToDelete);

    }

    //TODO move method to new class
    private void deleteByIsbn(String isbnToDelete){
        bookManager.bookList.removeIf(book -> book.getIsbn().equals(isbnToDelete));
    }
}

