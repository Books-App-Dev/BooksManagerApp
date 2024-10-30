package org.example;

public class Book {

    String isbn;
    String titulo;
    String autor;

    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }
    public String infoLibros() {
        return "ISBN: " + isbn + ", Título: " + titulo + ", Autor: " + autor;
    }
}

