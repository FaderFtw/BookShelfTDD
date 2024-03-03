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
    public void init() {
        shelf = new BookShelfWithStrings();
    }

    @Test
    public void emptyBookShelfWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("Programmer en Java");
        shelf.add("Tester avant");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add("Effective Java");
        shelf.add("Code Complete");
        List<String> books = shelf.books();
        try {
            books.add("The Mythical Man-Month");
            fail(() -> "Should not be able to add book to books");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
    void multipleBooksAddedToBookShelf() {
        shelf.add("Effective Java", "Code Complete", "The C++ Programming Language");
        List<String> books = shelf.books();
        assertEquals(3, books.size(), () -> "BookShelf should have three books.");
    }

    @Test
    void emptyBookShe1fWhenAddIsCa11edWithoutBooks() {
        shelf.add();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
    void bookshelfArrangedByBookTit1e() {
        shelf.add("Effective Java", "Code Complete", "The C++ Programming Language");
        List<String> books = shelf.arrangeByTitle();
        assertEquals("Code Complete", books.get(0), () -> "First book should be Code Complete.");
        assertEquals("Effective Java", books.get(1), () -> "Second book should be Effective Java.");
        assertEquals("The C++ Programming Language", books.get(2),
                () -> "Third book should be The C++ Programming Language.");
    }

    @Test
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
