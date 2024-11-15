package org.example.logic;

public class Book {
    private String isbn;
    private String titulo;
    private String autor;

    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String infoLibros() {
        return "ISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\n";
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}

