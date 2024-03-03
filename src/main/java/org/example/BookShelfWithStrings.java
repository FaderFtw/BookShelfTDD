package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BookShelfWithStrings {
    private final List<String> books = new ArrayList<>(); // Liste des titres de livres sur l'étagère

    // Méthode de récupération de la liste des titres de livres (version initiale)
    public List<String> books_v0() {
        return Collections.emptyList(); // Retourne une liste vide
    }

    // Méthode de récupération de la liste des titres de livres (version 1)
    public List<String> books_v1() {
        return books; // Retourne la liste des titres de livres
    }

    // Méthode de récupération de la liste des titres de livres (version immuable)
    public List<String> books() {
        return Collections.unmodifiableList(books); // Retourne une vue immuable de la liste des titres de livres
    }

    // Méthode d'ajout d'un titre de livre à l'étagère (version initiale)
    public void add_v0(String book) {
        books.add(book); // Ajoute le titre de livre à la liste
    }

    // Méthode d'ajout de plusieurs titres de livres à l'étagère
    public void add(String... bookTitles) {
        Collections.addAll(books, bookTitles); // Ajoute tous les titres de livres à la liste
    }

    // Méthode de tri des titres de livres par ordre alphabétique
    List<String> arrangeByTitle() {
        List<String> sortedBooks = new ArrayList<>(books); // Crée une nouvelle liste pour le tri
        Collections.sort(sortedBooks); // Trie les titres de livres par ordre alphabétique
        return sortedBooks; // Retourne la liste triée
    }
}
