package src.main;

import java.util.ArrayList;
import java.util.List;

public class LibraryStock {
    private List<Book> books;
    private List<User> users;

    public LibraryStock() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> listBook() {
        return new ArrayList<>(books);
    }

    public List<Book> searchBooks(String type, String value) {
        List<Book> response = new ArrayList<>();
        for (Book book : books) {
            if ("title".equalsIgnoreCase(type) && book.getTitle().toLowerCase().contains(value)) {
                response.add(book);
            } else if ("author".equalsIgnoreCase(type) && book.getAuthor().toLowerCase().contains(value)) {
                response.add(book);
            } else if ("genre".equalsIgnoreCase(type) && book.getGenre().toLowerCase().contains(value)) {
                response.add(book);
            }
        }
        return response;
    }

    public void registerNewUser(User user) {
        users.add(user);
    }

    public List<User> listUsers() {
        return new ArrayList<>(users);
    }

    public User searchPerson(String name) {
        for (User person : users) {
            if (person.getName().equalsIgnoreCase(name))
                return person;
        }
        return null;
    }
}
