package org.example;

import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean salir = false;
        int option;

        String number1 = "1";
        String number2 = "2";
        String number3 = "3";
        String number4 = "4";
        String number5 = "5";

    option = scanner.nextInt();

        System.out.println("Gestor de Libros Técnicos de Programación");
        System.out.println("1. Añadir libro");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Cambiar repositorio");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción:");

        Scanner number = new Scanner(System.in);
        String numberInput = number.nextLine();

        switch (option) {
            case 1:
                System.out.println("1. Añadir libro");
                break;
            case 2:
                System.out.println("2. Ver todos los libros");
                break;
            case 3:
                System.out.println("3. Eliminar libro");
                break;
            case 4:
                System.out.println("4. Cambiar repositorio");
                break;
            case 5:
                salir = true;
                break;
        }


    }
}