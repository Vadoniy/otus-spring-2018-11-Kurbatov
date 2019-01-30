package homework_6.shell.services.impl;

import homework_6.dao.AuthorRepositoryJpa;
import homework_6.dao.BookRepositoryJpa;
import homework_6.dao.BookReviewRepositoryJpa;
import homework_6.dao.GenreRepositoryJpa;
import homework_6.domain.Author;
import homework_6.domain.Book;
import homework_6.domain.BookReview;
import homework_6.domain.Genre;
import homework_6.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class LibraryServiceShellImpl implements LibraryServiceShell {

    private AuthorRepositoryJpa authorRepositoryJpa;
    private BookRepositoryJpa bookRepositoryJpa;
    private BookReviewRepositoryJpa reviewRepositoryJpa;
    private GenreRepositoryJpa genreRepositoryJpa;

    @Autowired
    public LibraryServiceShellImpl(AuthorRepositoryJpa authorRepositoryJpa, BookRepositoryJpa bookRepositoryJpa,
                               BookReviewRepositoryJpa reviewRepositoryJpa, GenreRepositoryJpa genreRepositoryJpa)
    {
        this.authorRepositoryJpa = authorRepositoryJpa;
        this.bookRepositoryJpa = bookRepositoryJpa;
        this.genreRepositoryJpa = genreRepositoryJpa;
        this.reviewRepositoryJpa = reviewRepositoryJpa;
    }

    @Override
    public void addAuthor(String penName) {
        authorRepositoryJpa.addAuthor(new Author(penName));
    }

    @Override
    public void addGenre(String genre) {
        genreRepositoryJpa.addGenre(new Genre(genre));
    }

    @Override
    public void addBook(String title, Author author, List<Genre> genres) {
        bookRepositoryJpa.addBook(new Book(title, authorRepositoryJpa.getByName(author.getPenName()), genres));
    }

    @Override
    public void addReview(String bookTitle, String reviewOwner, String review) {
        reviewRepositoryJpa.addReview(new BookReview(bookRepositoryJpa.getByName(bookTitle), reviewOwner, review));
    }

    @Override
    public String getAuthor(String penName) {
        return authorRepositoryJpa.getByName(penName).toString();
    }

    @Override
    public String getGenre(String genre) {
        return genreRepositoryJpa.getByName(genre).toString();
    }

    @Override
    public String getBook(String title) {
        return bookRepositoryJpa.getByName(title).toString();
    }

    @Override
    public String getReview(String bookTitle) {
        return reviewRepositoryJpa.getByBook(bookRepositoryJpa.getByName(bookTitle)).toString();
    }


    @Override
    public void deleteAuthor(long id) {

    }

    @Override
    public void deleteGenre(long id) {

    }

    @Override
    public List<String> getBooksList() {
        bookRepositoryJpa.getAll();
        List<String> books = new ArrayList<>();
        for (Book b : bookRepositoryJpa.getAll()){
            books.add(b.toString());
        }
        return books;
    }

    @Override
    public List<BookReview> getReviewsList() {
        return null;
    }

    @Override
    public List<String> getAuthorsList() {
        authorRepositoryJpa.getAll();
        List<String> authors = new ArrayList<>();
        for (Author a : authorRepositoryJpa.getAll()){
            authors.add(a.toString());
        }
        return authors;
    }

    @Override
    public List<String> getGenresList() {
        genreRepositoryJpa.getAll();
        List<String> genres = new ArrayList<>();
        for (Genre g : genreRepositoryJpa.getAll()){
            genres.add(g.toString());
        }
        return genres;
    }
}
