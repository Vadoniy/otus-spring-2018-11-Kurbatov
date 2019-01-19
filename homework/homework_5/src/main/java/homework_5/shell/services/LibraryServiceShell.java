package homework_5.shell.services;

import java.util.List;

public interface LibraryServiceShell {

    List<String> getAuthorsList();
    List<String> getGenresList();
    void addAuthor(long id, String pen_name);
    void addGenre(long id, String genre);
    void addBook(long id_book, String title, long id_author, long id_genre);
    void deleteAuthor(long id);
    void deleteGenre(long id);
    List<String> getBooksList();
    String getBook(long id);
}
