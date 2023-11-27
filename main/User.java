package src.main;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> booksRents;

    public User(String name) {
        this.name = name;
        this.booksRents = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", books rents: " + booksRents;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooksRents() {
        return booksRents;
    }

    public void rentBook(Book book) {
        booksRents.add(book);
    }

    public void returnBook(Book book) {
        booksRents.remove(book);
    }

}
