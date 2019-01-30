package homework_6.dao;

import homework_6.domain.Book;
import homework_6.domain.BookReview;

import java.util.List;

public interface BookReviewRepositoryJpa {
    BookReview getById(long bookReviewId);
    BookReview getByBook(Book book);
    List<BookReview> getAll();
    void addReview(BookReview newBookReview);
//    void deleteById(long bookReviewId);
    void deleteReview(BookReview review);
    void updateBookReview(BookReview bookReview);
}
