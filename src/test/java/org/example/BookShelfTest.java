package org.example;

import org.example.BookShelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookShelfTest {

    private BookShelf bookshelf;

    @BeforeEach
    void setUp() {
        bookshelf = new BookShelf();
    }

    @Test
    void emptyBookShelfWhenNoBookAdded() {
        assertTrue(bookshelf.isEmpty());
    }

    @Test
    void bookShelfContainsTwoBooksWhenTwoBooksAdded() {
        bookshelf.addBooks("Book1", "Book2");
        assertEquals(2, bookshelf.getNumberOfBooks());
    }

    @Test
    void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        bookshelf.addBooks();
        assertTrue(bookshelf.isEmpty());
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        bookshelf.addBooks("Book1", "Book2");
        List<String> books = bookshelf.getBooks();
        assertThrows(UnsupportedOperationException.class, () -> books.add("Book3"));
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        bookshelf.addBooks("C", "B", "A");
        bookshelf.arrangeByTitle();
        List<String> expected = List.of("A", "B", "C");
        assertEquals(expected, bookshelf.getBooks());
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        bookshelf.addBooks("C", "B", "A");
        bookshelf.arrangeByTitle();
        List<String> expected = new ArrayList<>(List.of("A", "B", "C"));
        assertEquals(expected, bookshelf.getBooks());
    }
}
