package homework_5.dao;

import homework_5.domain.Genre;

import java.util.List;

public interface GenreDao {
    int count();
    void insert(Genre genre);
    Genre getById(long id);
    void deleteById(long id);
    List<Genre> getAll();
}
