package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by b4ckl0g on 6/20/2017.
 */
public class Book {
    public Integer id;
    public String title;
    public Integer price;
    public String author;


    public Book() {

    }

    public Book(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    private static Set<Book> books;

    static {
        books = new HashSet<>();
        books.add(new Book(1, "C++", 20, "ABC"));
        books.add(new Book(2, "Java", 30, "XYZ"));
    }


    public static Set<Book> allBooks() {
        return books;
    }

    public static Book findByID(Integer id) {
        for (Book book : books) {
            if (id.equals(book.id)) {
                return book;
            }
        }
        return null;
    }

    public static void add(Book book) {
        books.add(book);
    }

    public static boolean remove(Book book) {
        return book.remove(book);
    }
}
