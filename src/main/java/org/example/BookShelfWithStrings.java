package org.example;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BookShelfWithStrings {
    private final List<String> books = new ArrayList<>();

    public List<String> books_v0() {
        return Collections.emptyList();
    }

    public List<String> books_v1() {
        return books;
    }

    public List<String> books() {
        return Collections.unmodifiableList(books);
    }

    public void add_v0(String book) {
        books.add(book);
    }

    public void add(String... bookTitles) {
        Collections.addAll(books, bookTitles);
    }

    List<String> arrangeByTitle() {
        List<String> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);
        return sortedBooks;
    }
}
