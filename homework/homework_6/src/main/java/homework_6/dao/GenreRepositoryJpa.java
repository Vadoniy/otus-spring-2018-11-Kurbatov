package homework_6.dao;

import homework_6.domain.Book;
import homework_6.domain.Genre;

import java.util.List;

public interface GenreRepositoryJpa {
    Genre getById(long genreId);
    Genre getByName(String genre);
    void addGenre(Genre newGenre);
    void deleteById(long genreId);
    void updateGenre(Genre genre);
    List<Genre> getAll();
}
