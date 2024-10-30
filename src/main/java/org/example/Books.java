package org.example;

public class Books {

    String isbn;
    String titulo;
    String autor;

    public Books(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }
    public String infoLibros() {
        return "ISBN: " + isbn + ", Título: " + titulo + ", Autor: " + autor;
    }
}

