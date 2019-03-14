package homework_8.repository;

import homework_8.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Book findById(String id);
    void deleteById(String id);
    Book findByTitle(String title);
    List<Book> findByAuthorPenName(String penName);
    List<Book> findByGenreGenre(String genre);
}