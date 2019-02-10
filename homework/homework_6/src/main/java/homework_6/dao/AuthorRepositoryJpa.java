package homework_6.dao;

import homework_6.domain.Author;

import java.util.List;

public interface AuthorRepositoryJpa {
    Author getById(long authorId);
    Author getByName(String penName);
    void addAuthor(Author newAuthor);
    void deleteById(long authorId);
    void updateAuthor(Author author);
    List<Author> getAll();
}