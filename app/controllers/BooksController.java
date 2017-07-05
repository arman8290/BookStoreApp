package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Set;

import views.html.books.*;

import javax.inject.Inject;

/**
 * Created by b4ckl0g on 6/20/2017.
 */
public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;


    public Result index() {
        Set<Book> books = Book.allBooks();
        return ok(index.render(books));
    }

    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    public Result save() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
    }

    public Result edit(Integer id) {
        Book book = Book.findByID(id);
        if (book == null) {
            return notFound("Book Not Found");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }

    public Result update() {
        Book book = formFactory.form(Book.class).bindFromRequest().get();
        Book oldBook = Book.findByID(book.id);
        if (oldBook == null) {
            return notFound("Book Not Found");
        }
        oldBook.title = book.title;
        oldBook.author = book.author;
        oldBook.price = book.price;
        return redirect(routes.BooksController.index());
    }

    public Result destroy(Integer id) {
        Book book = Book.findByID(id);
        if (book == null) {
            return notFound("Book Not Found");
        }
        return ok(show.render(book));
    }

    public Result show(Integer id) {
        Book book = Book.findByID(id);
        if (book == null) {
            return notFound("Book Not Found");
        }
        return ok(show.render(book));
    }


}
