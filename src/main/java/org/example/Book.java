package org.example;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private float price;

    public Book(String title, String author, String isbn, float price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;

        Book book = (Book) o;

        if (price != book.price)
            return false;
        if (!title.equals(book.title))
            return false;
        if (!author.equals(book.author))
            return false;
        return isbn.equals(book.isbn);
    }

    public static void main(String[] args) {
        Book book = new Book("Effective Java", "Joshua Bloch", "0321356683", 450);
        System.out.println(book);
    }

}
