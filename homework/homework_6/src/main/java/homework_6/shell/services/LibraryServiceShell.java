package homework_6.shell.services;

import homework_6.domain.Author;
import homework_6.domain.BookReview;
import homework_6.domain.Genre;

import java.util.List;

public interface LibraryServiceShell {
    void addAuthor(String penName);
    void addGenre(String genre);
    void addBook(String title, Author author, List<Genre> genres);
    void addReview(String bookTitle, String reviewOwner, String review);
    String getAuthor(String penName);
    String getGenre(String genre);
    String getBook(String title);
    String getReview(String bookTitle);
    void deleteAuthor(long id);
    void deleteGenre(long id);
    List<String> getAuthorsList();
    List<String> getGenresList();
    List<String> getBooksList();
    List<BookReview> getReviewsList();
}
