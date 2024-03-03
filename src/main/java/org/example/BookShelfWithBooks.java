package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShelfWithBooks {
    private final List<Book> books = new ArrayList<>();

    public List<String> books_v0() {
        return Collections.emptyList();
    }

    public List<Book> books_v1() {
        return books;
    }

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    public void add_v0(Book book) {
        books.add(book);
    }

    public void add(Book... bookTitles) {
        Collections.addAll(books, bookTitles);
    }

    List<Book> arrangeByTitle() {
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle));
        return sortedBooks;
    }
}
