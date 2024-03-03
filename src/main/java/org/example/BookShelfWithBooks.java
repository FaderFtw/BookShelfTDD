package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShelfWithBooks {
    private final List<Book> books = new ArrayList<>(); // Liste des livres sur l'étagère

    // Méthode de récupération de la liste des livres (version initiale)
    public List<String> books_v0() {
        return Collections.emptyList(); // Retourne une liste vide
    }

    // Méthode de récupération de la liste des livres (version 1)
    public List<Book> books_v1() {
        return books; // Retourne la liste des livres
    }

    // Méthode de récupération de la liste des livres (version immuable)
    public List<Book> books() {
        return Collections.unmodifiableList(books); // Retourne une vue immuable de la liste des livres
    }

    // Méthode d'ajout d'un livre à l'étagère (version initiale)
    public void add_v0(Book book) {
        books.add(book); // Ajoute le livre à la liste
    }

    // Méthode d'ajout de plusieurs livres à l'étagère
    public void add(Book... bookTitles) {
        Collections.addAll(books, bookTitles); // Ajoute tous les titres de livres à la liste
    }

    // Méthode de tri des livres par titre
    List<Book> arrangeByTitle() {
        List<Book> sortedBooks = new ArrayList<>(books); // Crée une nouvelle liste pour le tri
        sortedBooks.sort(Comparator.comparing(Book::getTitle)); // Trie les livres par titre
        return sortedBooks; // Retourne la liste triée
    }
}
