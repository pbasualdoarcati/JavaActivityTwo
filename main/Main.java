package src.main;

import java.util.*;
import javax.swing.*;

public class Main {
    static LibraryStock libraryStock = new LibraryStock();

    public static void main(String[] args) {
        showMenu();
    }

    private static String inputText(String textInput) throws Exception {
        String input = JOptionPane.showInputDialog(null, textInput);
        if (input == null || input.trim().isEmpty()) {
            throw new Exception("The text doesn't blank");
        }
        return input;
    }

    private static void registerPerson() {
        try {
            String userName = inputText("Enter your name");
            User newUser = new User(userName);
            libraryStock.registerNewUser(newUser);
            JOptionPane.showMessageDialog(null, "Register successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void addBook() {
        try {
            String title = inputText("Add the title");
            String author = inputText("Add the author");
            String genre = inputText("Add the genre");
            Book newBook = new Book(title, author, genre);
            libraryStock.addBook(newBook);
            JOptionPane.showMessageDialog(null, "Book add successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void searchBook() {
        String[] options = { "Search with title", "Search with author", "Search with genre", "Exit" };
        Integer optionselect = JOptionPane.showOptionDialog(null, "Select an option", "Search book",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (optionselect) {
            case 0:
                searchTitle();
                break;
            case 1:
                searchAuthor();
                break;
            case 2:
                searchGenre();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void searchTitle() {
        try {
            String title = inputText("Add the title");
            List<Book> response = libraryStock.searchBooks("title", title);
            StringBuilder message = new StringBuilder("List of search results by title: \n ");
            for (Book book : response) {
                message.append(book.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(), "List of books", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void searchAuthor() {
        try {
            String author = inputText("Add the author");
            List<Book> response = libraryStock.searchBooks("author", author);
            StringBuilder message = new StringBuilder("List of search results by title: \n ");
            for (Book book : response) {
                message.append(book.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(), "List of books", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void searchGenre() {
        try {
            String genre = inputText("Add the genre");
            List<Book> response = libraryStock.searchBooks("genre", genre);
            StringBuilder message = new StringBuilder("List of search results by title: \n ");
            for (Book book : response) {
                message.append(book.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(), "List of books", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteBook() {
        try {
            String title = inputText("Add the title");
            Book book = libraryStock.searchBooks("title", title).stream().findFirst().orElse(null);
            if (book != null) {
                libraryStock.removeBook(book);
                JOptionPane.showMessageDialog(null, "Deleted book");
            } else {
                JOptionPane.showMessageDialog(null, "Book doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void rentABook() {
        try {
            String title = inputText("Add the title");
            String person = inputText("Add the user");
            User personSearch = libraryStock.searchPerson(person);
            Book book = libraryStock.searchBooks("title", title).stream().findFirst().orElse(null);

            if (personSearch != null && book != null) {
                personSearch.rentBook(book);
                JOptionPane.showMessageDialog(null, "Rented book correctly");
            } else {
                JOptionPane.showMessageDialog(null, "User or book dosen't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void returnABook() {
        try {
            String title = inputText("Add the title");
            String person = inputText("Add the user");
            User personSearch = libraryStock.searchPerson(person);
            Book book = libraryStock.searchBooks("title", title).stream().findFirst().orElse(null);

            if (personSearch != null && book != null) {
                personSearch.returnBook(book);
                JOptionPane.showMessageDialog(null, "Book returned correctly");
            } else {
                JOptionPane.showMessageDialog(null, "User or book dosen't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void showMenu() {
        String[] options = { "Register new user", "Add book", "Search Book", "Delete book", "Rent book", "Return book",
                "Exit" };
        Integer optionselect = JOptionPane.showOptionDialog(null, "Select an option", "Library",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (optionselect) {
            case 0:
                registerPerson();
                break;
            case 1:
                addBook();
                break;
            case 2:
                searchBook();
                break;
            case 3:
                deleteBook();
                break;
            case 4:
                rentABook();
                break;
            case 5:
                returnABook();
                break;
            case 6:
                System.exit(0);
                break;

            default:
                System.exit(0);
                break;
        }
    }
}
