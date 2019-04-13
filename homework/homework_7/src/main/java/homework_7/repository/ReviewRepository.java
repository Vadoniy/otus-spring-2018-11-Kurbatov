package homework_7.repository;

import homework_7.domain.Book;
import homework_7.domain.BookReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<BookReview, Long> {
    BookReview findByBook(Book book);
}
