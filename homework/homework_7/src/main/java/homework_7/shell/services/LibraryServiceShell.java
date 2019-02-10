package homework_7.shell.services;

import java.util.List;

public interface LibraryServiceShell {
    void addAuthor(String penName);
    void addGenre(String genre);
    void addBook(String title, String author, String genre);
    void addReview(String bookTitle, String reviewOwner, String review);
    void updateBook(long bookId, String title, String author, String genre);
    void updateReview(long reviewId, String reviewOwner, String review);
    String getAuthorByName(String penName);
    String getAuthorById(long authorId);
    String getGenre(String genre);
    String getGenreById(long genreId);
    String getBookByName(String title);
    String getBookById(long bookId);
    String getReviewByBookTitle(String bookTitle);
    String getReviewById(long reviewId);
    String getReviewByBookId(long bookId);
    void deleteAuthor(long id);
    void deleteGenre(long id);
    void deleteBook(long id);
    void deleteReview(long id);
    List<String> getAuthorsList();
    List<String> getGenresList();
    List<String> getBooksList();
    List<String> getReviewsList();
}
