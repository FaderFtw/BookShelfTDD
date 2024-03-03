package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookShelfWithBooksTest {
    private BookShelfWithBooks shelf;

    @BeforeEach
    // Avant chaque test, initialise une nouvelle étagère à livres
    public void init() {
        shelf = new BookShelfWithBooks();
    }

    @Test
    // Teste le cas où aucune livre n'a été ajouté
    public void emptyBookShelfWhenNoBookAdded() {
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
        // Teste le cas où deux livres ont été ajoutés
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        // Ajoute deux livres à l'étagère
        shelf.add(new Book("Programmer en Java", "Jean-Michel Doudoux", "978-2100809132", 30.0f));
        shelf.add(new Book("Tester avant", "Gilles Roux", "978-2212133017", 25.0f));
        List<Book> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
        // Teste l'immutabilité de la liste des livres retournée par l'étagère
    void booksReturnedFromBookShelfIsImmutableForClient() {
        // Ajoute deux livres à l'étagère
        shelf.add(new Book("Effective Java", "Joshua Bloch", "978-0134685991", 30.0f));
        shelf.add(new Book("Code Complete", "Steve McConnell", "978-0735619678", 40.0f));
        List<Book> books = shelf.books();
        try {
            // Tente d'ajouter un livre à la liste retournée par l'étagère
            books.add(new Book("The C++ Programming Language", "Bjarne Stroustrup", "978-0321563842", 50.0f));
            fail(() -> "Should not be able to add book to books");
        } catch (Exception e) {
            // Vérifie que l'exception levée est de type UnsupportedOperationException
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
        // Teste le cas où plusieurs livres ont été ajoutés à l'étagère
    void multipleBooksAddedToBookShelf() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991", 30.0f);
        Book book2 = new Book("Code Complete", "Steve McConnell", "978-0735619678", 40.0f);
        Book book3 = new Book("The C++ Programming Language", "Bjarne Stroustrup", "978-0321563842", 50.0f);
        shelf.add(book1, book2, book3);
        List<Book> books = shelf.books();
        assertEquals(3, books.size(), () -> "BookShelf should have three books.");
    }

    @Test
        // Teste le cas où l'étagère est vide après avoir ajouté sans livres
    void emptyBookShelfWhenAddIsCa11edWithoutBooks() {
        shelf.add();
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
        // Teste si les livres sur l'étagère sont triés par titre
    void bookshelfArrangedByBookTit1e() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991", 30.0f);
        Book book2 = new Book("Code Complete", "Steve McConnell", "978-0735619678", 40.0f);
        Book book3 = new Book("The C++ Programming Language", "Bjarne Stroustrup", "978-0321563842", 50.0f);
        shelf.add(book1, book2, book3);
        List<Book> books = shelf.arrangeByTitle();
        assertEquals(book2, books.get(0), () -> "First book should be Code Complete.");
        assertEquals(book1, books.get(1), () -> "Second book should be Effective Java.");
        assertEquals(book3, books.get(2), () -> "Third book should be The C++ Programming Language.");
    }

    @Test
        // Teste si les livres sur l'étagère restent dans l'ordre d'insertion après l'appel de la méthode arrangeByTitle
    void booksInBookShe1fAreInInsertionOrderAfterCa11ingArrange() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991", 30.0f);
        Book book2 = new Book("Code Complete", "Steve McConnell", "978-0735619678", 40.0f);
        Book book3 = new Book("The C++ Programming Language", "Bjarne Stroustrup", "978-0321563842", 50.0f);
        shelf.add(book1, book2, book3);
        shelf.arrangeByTitle();
        List<Book> books = shelf.books();
        assertEquals(book1, books.get(0), () -> "First book should be Effective Java.");
        assertEquals(book2, books.get(1), () -> "Second book should be Code Complete.");
        assertEquals(book3, books.get(2), () -> "Third book should be The C++ Programming Language.");
    }

}
