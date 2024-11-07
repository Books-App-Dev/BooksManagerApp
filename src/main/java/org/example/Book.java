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

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String infoLibros() {
        return "ISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\n";
    }

}

