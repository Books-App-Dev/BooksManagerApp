package org.example;

import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number1 = "1";
        String number2 = "2";
        String number3 = "3";
        String number4 = "4";
        String number5 = "5";

        Scanner number = new Scanner(System.in);

        String numberInput = number.nextLine();

        System.out.println("Gestor de Libros Técnicos de Programación");
        System.out.println("1. Añadir libro");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Cambiar repositorio");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción: " + numberInput);

    }
}