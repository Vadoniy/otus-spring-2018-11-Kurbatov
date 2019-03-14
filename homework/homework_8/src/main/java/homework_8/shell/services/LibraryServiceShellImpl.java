package homework_8.shell.services;

import homework_8.domain.Author;
import homework_8.domain.Book;
import homework_8.domain.Genre;
import homework_8.domain.Review;
import homework_8.repository.BookRepository;
import homework_8.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class LibraryServiceShellImpl implements LibraryServiceShell {

    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;

    public LibraryServiceShellImpl() {
    }

    @Autowired
    public LibraryServiceShellImpl(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void addBook(String title, String author, String genre) {
        List<Book> tempBooks = bookRepository.findByAuthorPenName(author);
        Author author1;
        if (tempBooks.size()>0){
            author1 = tempBooks.get(0).getAuthor();
        } else {
            author1 = new Author(author);
        }
        Genre genre1;
        if (tempBooks.size()>0){
            genre1 = tempBooks.get(0).getGenre();
        } else {
            genre1 = new Genre(genre);
        }
        bookRepository.save(new Book(title, author1, genre1));
    }

    @Override
    public void updateBook(String bookId, String title, String author, String genre) {
        Book cacheBook = bookRepository.findById(bookId);
        if (cacheBook == null){
            System.err.println("Unknown book.");
            return;
        }
        List<Book> tempBooks = bookRepository.findByAuthorPenName(author);
        Author author1;
        if (tempBooks.size()>0){
            author1 = tempBooks.get(0).getAuthor();
        } else {
            author1 = new Author(author);
        }
        Genre genre1;
        tempBooks = bookRepository.findByGenreGenre(author);
        if (tempBooks.size()>0){
            genre1 = tempBooks.get(0).getGenre();
        } else {
            genre1 = new Genre(genre);
        }
        cacheBook.setTitle(title);
        cacheBook.setAuthor(author1);
        cacheBook.setGenre(genre1);
        bookRepository.save(cacheBook);
    }

    @Override
    public String getBookByTitle(String title) {
        return bookRepository.findByTitle(title).toString();
    }

    @Override
    public List<String> getBookByGenre(String genre) {
        List<String> books = new ArrayList<>();
        bookRepository.findByGenreGenre(genre).forEach(book -> books.add(book.toString()));
        return books;
    }

    @Override
    public String getBookById(String bookId) {
        return bookRepository.findById(bookId).toString();
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<String> getBooksList() {
        List<String> books = new ArrayList<>();
        List<Book> cacheBook = bookRepository.findAll();
        if (cacheBook.size() == 0) {
            books.add("There are no books");
        } else {
            cacheBook.forEach(book -> books.add(book.toString()));
        }
        return books;
    }

    @Override
    public void addReview(String bookTitle, String review, String reviewOwner) {

        Book cacheBook = bookRepository.findByTitle(bookTitle);
        if (cacheBook == null){
            System.err.println("There's no book with title " + bookTitle);
            return;
        }

        reviewRepository.save(new Review(cacheBook, review, reviewOwner));
    }

    @Override
    public void updateReview(String reviewId, String reviewOwner, String review) {
        Review cacheReview = reviewRepository.findById(reviewId);
        if (cacheReview == null){
            System.err.println("There's no review with id " + reviewId);
            return;
        }
        cacheReview.setReviewOwner(reviewOwner);
        cacheReview.setReview(review);
        reviewRepository.save(cacheReview);
    }

    @Override
    public String getReviewByBookTitle(String bookTitle) {
        return reviewRepository.findByBookTitle(bookTitle).toString();
    }

    @Override
    public String getReviewById(String reviewId) {
        return reviewRepository.findById(reviewId).toString();
    }

    @Override
    public String getReviewByBookId(String bookId) {
        Book cacheBook = bookRepository.findById(bookId);
        if (cacheBook == null){
            System.err.println("There's no book with id " + bookId);
            return null;
        } else {
            return reviewRepository.findByBookTitle(bookRepository.findById(bookId).getTitle()).toString();
        }
    }

    @Override
    public List<String> getReviewByReviewOwner(String reviewOwner) {
        List<Review> cacheReviews = reviewRepository.findByReviewOwner(reviewOwner);
        if (cacheReviews == null){
            System.err.println("There's no reviews by owner " + reviewOwner);
            return null;
        } else {
            List<String> reviews = new ArrayList<>();
            cacheReviews.forEach(review -> reviews.add(review.toString()));
            return reviews;
        }
    }

    @Override
    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<String> getReviewsList() {
        List<String> reviews = new ArrayList<>();
        List<Review> cacheReviews = reviewRepository.findAll();
        if (cacheReviews.size() == 0) {
            reviews.add("There are no reviews");
        } else {
            cacheReviews.forEach(review -> reviews.add(review.toString()));
        }
        return reviews;
    }
}
