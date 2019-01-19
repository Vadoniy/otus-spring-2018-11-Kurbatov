package homework_5.dao;

import homework_5.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();
    void insert(Author author);
    Author getById(long id);
    void deleteById(long id);
    List<Author> getAll();
}
