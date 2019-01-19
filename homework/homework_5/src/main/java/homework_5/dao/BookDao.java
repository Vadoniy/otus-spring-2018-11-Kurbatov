package homework_5.dao;

import homework_5.domain.Author;
import homework_5.domain.Book;
import homework_5.domain.Genre;

import java.util.List;

public interface BookDao {
    int count();
    void insert(Book book, Author author, Genre genre);
    Book getById(long id);
    void deleteById(long id);
    List<Book> getAll();
}
