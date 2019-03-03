package homework_8.shell.services;

import homework_8.domain.Book;

import java.util.List;

public interface LibraryServiceShell {

//    -------------------------Book-------------------------
    void addBook(String title, String author, String genre);
    void updateBook(String bookId, String title, String author, String genre);
    String getBookByTitle(String title);
    List<String> getBookByGenre(String genre);
    String getBookById(String id);
    void deleteBook(String id);
    List<String> getBooksList();

//    -------------------------Review-----------------------
    void addReview(String bookTitle, String review, String reviewOwner);
    void updateReview(String reviewId, String reviewOwner, String review);
    String getReviewById(String reviewId);
    String getReviewByBookId(String bookId);
    String getReviewByBookTitle(String bookTitle);
    List<String> getReviewByReviewOwner(String reviewOwner);
    void deleteReview(String id);
    List<String> getReviewsList();
}