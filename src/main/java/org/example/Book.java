package org.example;

public class Book {
//Atributos
    String isbn;
    String titulo;
    String autor;
//Constructor
    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }
//Getters y setters



    public String infoLibros() {
        return "ISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\n";
    }

}

