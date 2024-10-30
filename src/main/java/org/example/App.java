package org.example;

import java.util.Scanner;

public class App {
    public void printMenu() {
        Book book1 = new Book("A123", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("A240", "El príncipe de la niebla", "Carlos Ruiz Zafón");
        Book book3 = new Book("A360", "Harry Potter", "J.K.Rowling");

        Book[] books = {book1, book2, book3};

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nGestor de Libros Técnicos de Programación\n");
        String[] menu = {
                "1. Añadir libro",
                "2. Ver todos los libros",
                "3. Eliminar libro",
                "4. Cambiar repositorio",
                "5. Salir"
        };

        Byte option = 0;
        while (option != 5) {
            for (String item : menu) {
                System.out.println(item);
            }

            System.out.println("\nSeleccione una opción:");
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

            if (option == 2) {

                for (Book book : books) {
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

