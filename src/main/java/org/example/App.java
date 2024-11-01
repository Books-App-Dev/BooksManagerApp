package org.example;
import org.example.util.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class App {
    public void printMenu() {
        Book book1 = new Book("A123", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("A240", "El príncipe de la niebla", "Carlos Ruiz Zafón");
        Book book3 = new Book("A360", "Harry Potter", "J.K.Rowling");

        Book[] books = {book1, book2, book3};
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(books));

        Scanner scanner = new Scanner(System.in);
        //Cambiamos color usando class Color y su atributo - color WHITE
        System.out.println(Color.CYAN + "\nGestor de Libros Técnicos de Programación\n" + Color.RESET); //Cambiamos color usando class Color y su atributo - color
        String[] menu = {
                "1. Añadir libro",
                "2. Ver todos los libros",
                "3. Eliminar libro",
                "4. Cambiar repositorio",
                "5. Salir"
        };




        Byte option = 0;
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

            if (option == 1) {
                int count = 0;

                System.out.println("Ingrese el título: ");
                String scTitle = scanner.nextLine();
                System.out.println("Ingrese el autor: ");
                String  scAuthor = scanner.nextLine();
                System.out.println("Ingrese el ISBN (una letra seguida de tres números, por ejemplo, A123): ");
                String scISBN = scanner.nextLine();

                Book createdBook = new Book(scISBN, scTitle, scAuthor);
                bookList.add(createdBook);

                for (Book book : bookList) {
                    System.out.println(book.infoLibros());
                }
            }

            if (option == 2) {

                for (Book book : bookList) {
                    System.out.println(book.infoLibros());
                }
                if (books.length == 0) {
                    System.out.println("No hay libros en la colección.");
                }
            }
            System.out.println("\nHas elegido: " + menu[option - 1]);
        }
    }
}

