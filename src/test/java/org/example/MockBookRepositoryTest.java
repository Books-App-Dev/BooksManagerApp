package org.example;

import logic.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistance.InMemoryBookRepository;

import java.util.List;
import java.util.Optional;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MockBookRepositoryTest {
    @Mock
    private InMemoryBookRepository repositoryMock;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveBookWhenIsCreatedTest(){
        //Given
        String isbn = "E666";
        String title = "Lluvia";
        String author = "Doña Maruja";

        Book book = new Book(isbn, title, author);

        //When
        when(repositoryMock.findAll()).thenReturn(List.of(book));
        repositoryMock.save(book);

        //Then
        List<Book> bookList = repositoryMock.findAll();
        assertEquals(isbn, bookList.get(0).getIsbn());
        assertEquals(title, bookList.get(0).getTitulo());
        assertEquals(author, bookList.get(0).getAutor());
        verify(repositoryMock, times(1)).save(book);
    }

    @Test
    void findAllBooksInMemoryRepositoryTest() {
        //Given
        Book book1 = new Book("E666", "Lluvia", "Autor1");
        Book book2 = new Book("E999", "Lluvia2", "Autor2");

        //When
        when(repositoryMock.findAll()).thenReturn(List.of(book1, book2));
        List<Book> listBooks = repositoryMock.findAll();

        //Then
        assertEquals(2, listBooks.size());
        verify(repositoryMock, times(1)).findAll();
    }

    @Test
    void findBookByIsbnTest() {
        //Given
        Book book = new Book("E666", "Lluvia", "Autor1");

        //When
        when(repositoryMock.findByIsbn("E666")).thenReturn(Optional.of(book));
        Optional<Book> foundBook = repositoryMock.findByIsbn("E666");

        //Then
        assertTrue(foundBook.isPresent());
        assertEquals("E666", foundBook.get().getIsbn());
        verify(repositoryMock, times(1)).findByIsbn("E666");
    }

    @Test
    void deleteBookByIsbnTest() {
        //Given
        Book book = new Book("E666", "Lluvia", "Autor1");

        //When
        doNothing().when(repositoryMock).deleteByIsbn("E666");
        repositoryMock.deleteByIsbn("E666");

        //Then
        verify(repositoryMock, times(1)).deleteByIsbn("E666");
    }
}
