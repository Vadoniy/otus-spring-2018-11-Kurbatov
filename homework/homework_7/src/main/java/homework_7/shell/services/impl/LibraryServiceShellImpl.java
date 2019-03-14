package homework_7.shell.services.impl;

import homework_7.repository.AuthorRepository;
import homework_7.repository.BookRepository;
import homework_7.repository.GenreRepository;
import homework_7.repository.ReviewRepository;
import homework_7.domain.Author;
import homework_7.domain.Book;
import homework_7.domain.BookReview;
import homework_7.domain.Genre;
import homework_7.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class LibraryServiceShellImpl implements LibraryServiceShell {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public LibraryServiceShellImpl(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository, ReviewRepository reviewRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addAuthor(String penName) {
        authorRepository.save(new Author(penName));
    }

    @Override
    public void addGenre(String genre) {
        genreRepository.save(new Genre(genre));
    }

    @Override
    public void addBook(String title, String author, String genre) {
        Author author1 = authorRepository.findByPenName(author);
        if (author1 == null) {
            System.err.println("Unknown author.");
            return;
        }
        Genre genre1 = genreRepository.findByGenre(genre);
        if (genre1 == null) {
            System.err.println("Unknown genre.");
            return;
        }
        bookRepository.save(new Book(title, author1, genre1));
    }

    @Override
    public void addReview(String bookTitle, String reviewOwner, String review) {
        reviewRepository.save(new BookReview(bookRepository.findByTitle(bookTitle), reviewOwner, review));

    }

    @Override
    public void updateBook(long bookId, String title, String author, String genre) {
        Book cacheBook = bookRepository.findById(bookId).get();
        if (cacheBook == null){
            System.err.println("Unknown book.");
            return;
        }
        Author author1 = authorRepository.findByPenName(author);
        if (author1 == null) {
            System.err.println("Unknown author.");
            return;
        }
        Genre genre1 = genreRepository.findByGenre(genre);
        if (genre1 == null) {
            System.err.println("Unknown genre.");
            return;
        }
        cacheBook.setTitle(title);
        cacheBook.setAuthor(author1);
        cacheBook.setGenre(genre1);
        bookRepository.save(cacheBook);
    }

    @Override
    public void updateReview(long reviewId, String reviewOwner, String review) {
        BookReview cacheReview = reviewRepository.findById(reviewId).get();
        if (cacheReview == null){
            System.err.println("There's no review with id " + reviewId);
            return;
        }
        cacheReview.setReviewOwner(reviewOwner);
        cacheReview.setReview(review);
        reviewRepository.save(cacheReview);
    }

    @Override
    public String getAuthorByName(String penName) {
        return authorRepository.findByPenName(penName).toString();
    }

    @Override
    public String getAuthorById(long authorId) {
        return authorRepository.findById(authorId).toString();
    }

    @Override
    public String getGenre(String genre) {
        return genreRepository.findByGenre(genre).toString();
    }

    @Override
    public String getGenreById(long genreId) {
        return genreRepository.findById(genreId).toString();
    }

    @Override
    public String getBookByName(String title) {
        return bookRepository.findByTitle(title).toString();
    }

    @Override
    public String getBookById(long bookId) {
        return bookRepository.findById(bookId).toString();
    }

    @Override
    public String getReviewByBookTitle(String bookTitle) {
        return reviewRepository.findByBook(bookRepository.findByTitle(bookTitle)).toString();
    }

    @Override
    public String getReviewById(long reviewId) {
        return reviewRepository.findById(reviewId).toString();
    }

    @Override
    public String getReviewByBookId(long bookId) {
        return reviewRepository.findByBook(bookRepository.findById(bookId).get()).toString();
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteGenre(long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<String> getAuthorsList() {
        List<String> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authors.add(author.toString()));
        return authors;
    }

    @Override
    public List<String> getGenresList() {
        List<String> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genre -> genres.add(genre.toString()));
        return genres;
    }

    @Override
    public List<String> getBooksList() {
        List<String> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book.toString()));
        return books;
    }

    @Override
    public List<String> getReviewsList() {
        List<String> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(bookReview -> reviews.add(bookReview.toString()));
        return reviews;
    }
}
