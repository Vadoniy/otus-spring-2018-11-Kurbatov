package homework_5.services;

import java.util.List;

public interface LibraryService {
    List<String> getAuthorsList();
    List<String> getGenresList();
    void addAuthor(long id, String pen_name);
    void addGenre(long id, String genre);
    void deleteAuthor(long id);
    void deleteGenre(long id);
    List<String> getBooksList();
    String getBook(long id);
}
