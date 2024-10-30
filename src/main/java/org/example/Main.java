package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Books books = new Books("A123", "Effective Java", "Joshua Bloch");

        Scanner scanner = new Scanner(System.in);

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

            System.out.println("Seleccione una opción:");
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
                System.out.println(books.infoLibros());
                continue;
            }

            System.out.println("Has elegido: " + menu[option - 1]);



        }
    }
}

