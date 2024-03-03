package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookshelfWithStringsTest {
    private BookShelfWithStrings shelf;

    @BeforeEach
    // Avant chaque test, initialise une nouvelle étagère à livres
    public void init() {
        shelf = new BookShelfWithStrings();
    }

    @Test
    // Teste le cas où aucune livre n'a été ajouté
    public void emptyBookShelfWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
        // Teste le cas où deux livres ont été ajoutés
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        // Ajoute deux livres à l'étagère
        shelf.add("Programmer en Java");
        shelf.add("Tester avant");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
        // Teste l'immutabilité de la liste des livres retournée par l'étagère
    void booksReturnedFromBookShelfIsImmutableForClient() {
        // Ajoute deux livres à l'étagère
        shelf.add("Effective Java");
        shelf.add("Code Complete");
        List<String> books = shelf.books();
        try {
            // Tente d'ajouter un livre à la liste retournée par l'étagère
            books.add("The Mythical Man-Month");
            fail(() -> "Should not be able to add book to books");
        } catch (Exception e) {
            // Vérifie que l'exception levée est de type UnsupportedOperationException
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
        // Teste le cas où plusieurs livres ont été ajoutés à l'étagère
    void multipleBooksAddedToBookShelf() {
        shelf.add("Effective Java", "Code Complete", "The C++ Programming Language");
        List<String> books = shelf.books();
        assertEquals(3, books.size(), () -> "BookShelf should have three books.");
    }

    @Test
        // Teste le cas où l'étagère est vide après avoir ajouté sans livres
    void emptyBookShe1fWhenAddIsCa11edWithoutBooks() {
        shelf.add();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
        // Teste si les livres sur l'étagère sont triés par titre
    void bookshelfArrangedByBookTit1e() {
        shelf.add("Effective Java", "Code Complete", "The C++ Programming Language");
        List<String> books = shelf.arrangeByTitle();
        assertEquals("Code Complete", books.get(0), () -> "First book should be Code Complete.");
        assertEquals("Effective Java", books.get(1), () -> "Second book should be Effective Java.");
        assertEquals("The C++ Programming Language", books.get(2),
                () -> "Third book should be The C++ Programming Language.");
    }

    @Test
        // Teste si les livres sur l'étagère restent dans l'ordre d'insertion après l'appel de la méthode arrangeByTitle
    void booksInBookShe1fAreInInsertionOrderAfterCa11ingArrange() {
        shelf.add("Effective Java", "Code Complete", "The C++ Programming Language");
        shelf.arrangeByTitle();
        List<String> books = shelf.books();
        assertEquals("Effective Java", books.get(0), () -> "First book should be Effective Java.");
        assertEquals("Code Complete", books.get(1), () -> "Second book should be Code Complete.");
        assertEquals("The C++ Programming Language", books.get(2),
                () -> "Third book should be The C++ Programming Language.");
    }

}
