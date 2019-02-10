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
    public void addBook(String title, String author, String genre) {
        Author author1 = authorRepositoryJpa.getByName(author);
        if (author1 == null) {
            System.err.println("Unknown author.");
            return;
        }
        Genre genre1 = genreRepositoryJpa.getByName(genre);
        if (genre1 == null) {
            System.err.println("Unknown genre.");
            return;
        }
        bookRepositoryJpa.addBook(new Book(title, author1, genre1));
    }

    @Override
    public void addReview(String bookTitle, String reviewOwner, String review) {
        reviewRepositoryJpa.addReview(new BookReview(bookRepositoryJpa.getByName(bookTitle), reviewOwner, review));
    }

    @Override
    public void updateBook(long bookId, String title, String author, String genre) {
        Book cacheBook = bookRepositoryJpa.getById(bookId);
        if (cacheBook == null){
            System.err.println("Unknown book.");
            return;
        }
        Author author1 = authorRepositoryJpa.getByName(author);
        if (author1 == null) {
            System.err.println("Unknown author.");
            return;
        }
        Genre genre1 = genreRepositoryJpa.getByName(genre);
        if (genre1 == null) {
            System.err.println("Unknown genre.");
            return;
        }

        cacheBook.setTitle(title);
        cacheBook.setAuthor(author1);
        cacheBook.setGenre(genre1);

        bookRepositoryJpa.updateBook(cacheBook);
    }

    @Override
    public void updateReview(long reviewId, String reviewOwner, String review) {
        BookReview cacheReview = reviewRepositoryJpa.getById(reviewId);
        if (cacheReview == null){
            System.err.println("There's no review with id " + reviewId);
            return;
        }

        cacheReview.setReviewOwner(reviewOwner);
        cacheReview.setReview(review);

        reviewRepositoryJpa.updateBookReview(cacheReview);
    }

    @Override
    public String getAuthorByName(String penName) {
        return authorRepositoryJpa.getByName(penName).toString();
    }

    @Override
    public String getAuthorById(long authorId) {
        return authorRepositoryJpa.getById(authorId).toString();
    }

    @Override
    public String getGenre(String genre) {
        return genreRepositoryJpa.getByName(genre).toString();
    }

    @Override
    public String getGenreById(long genreId) {
        return genreRepositoryJpa.getById(genreId).toString();
    }

    @Override
    public String getBookByName(String title) {
        return bookRepositoryJpa.getByName(title).toString();
    }

    @Override
    public String getBookById(long bookId) {
        return bookRepositoryJpa.getById(bookId).toString();
    }

    @Override
    public String getReviewByBookTitle(String bookTitle) {
        return reviewRepositoryJpa.getByBook(bookRepositoryJpa.getByName(bookTitle)).toString();
    }

    @Override
    public String getReviewById(long reviewId) {
        return reviewRepositoryJpa.getById(reviewId).toString();
    }

    @Override
    public String getReviewByBookId(long bookId) {
        return reviewRepositoryJpa.getByBook(bookRepositoryJpa.getById(bookId)).toString();
    }


    @Override
    public void deleteAuthor(long id) {
        authorRepositoryJpa.deleteById(id);
    }

    @Override
    public void deleteGenre(long id) {
        genreRepositoryJpa.deleteById(id);
    }

    @Override
    public void deleteBook(long id) {
        bookRepositoryJpa.deleteById(id);
    }

    @Override
    public void deleteReview(long id) {

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
    public List<String> getReviewsList() {
        List<String> reviews = new ArrayList<>();
        for (BookReview r : reviewRepositoryJpa.getAll()){
            reviews.add(r.toString());
        }
        return reviews;
    }

    @Override
    public List<String> getAuthorsList() {
        List<String> authors = new ArrayList<>();
        for (Author a : authorRepositoryJpa.getAll()){
            authors.add(a.toString());
        }
        return authors;
    }

    @Override
    public List<String> getGenresList() {
        List<String> genres = new ArrayList<>();
        for (Genre g : genreRepositoryJpa.getAll()){
            genres.add(g.toString());
        }
        return genres;
    }
}
