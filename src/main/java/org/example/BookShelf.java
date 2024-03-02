package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookShelf {
    private List<String> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void addBooks(String... bookTitles) {
        Collections.addAll(books, bookTitles);
    }

    public int getNumberOfBooks() {
        return books.size();
    }

    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void arrangeByTitle() {
        Collections.sort(books);
    }
}
