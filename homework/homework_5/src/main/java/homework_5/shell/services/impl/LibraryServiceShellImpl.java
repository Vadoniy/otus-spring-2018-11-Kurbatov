package homework_5.shell.services.impl;

import homework_5.dao.AuthorDao;
import homework_5.dao.BookDao;
import homework_5.dao.GenreDao;
import homework_5.domain.Author;
import homework_5.domain.Book;
import homework_5.domain.Genre;
import homework_5.shell.services.LibraryServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class LibraryServiceShellImpl implements LibraryServiceShell {

    private AuthorDao authorDao;
    private GenreDao genreDao;
    private BookDao bookDao;

    @Autowired
    public LibraryServiceShellImpl(AuthorDao authorDao, GenreDao genreDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.bookDao = bookDao;
    }

    @Override
    public List<String> getAuthorsList() {
        List<Author> authors = authorDao.getAll();
        List<String> authorsList = new ArrayList<>();

        for (int i = 0; i < authors.size(); i++){
            authorsList.add(authors.toString());
        }

        return authorsList;
    }

    @Override
    public List<String> getGenresList() {
        List<Genre> genres = genreDao.getAll();
        List<String> genresList = new ArrayList<>();

        for (int i = 0; i < genres.size(); i++){
            genresList.add(genres.toString());
        }

        return genresList;
    }

    @Override
    public List<String> getBooksList() {
        List<Book> books = bookDao.getAll();
        List<String> booksList = new ArrayList<>();

        for (int i = 0; i < books.size(); i++){
            booksList.add(books.toString());
        }

        return booksList;
    }

    @Override
    public void addAuthor(long id, String pen_name) {
        authorDao.insert(new Author(id, pen_name));
    }

    @Override
    public void addGenre(long id, String genre) {
        genreDao.insert(new Genre(id, genre));
    }

    @Override
    public void addBook(long id_book, String title, long id_author, long id_genre) {
        bookDao.insert(new Book(id_book, title), authorDao.getById(id_author), genreDao.getById(id_genre));
    }

    @Override
    public void deleteAuthor(long id) {
        authorDao.deleteById(id);
    }

    @Override
    public void deleteGenre(long id) {
        genreDao.deleteById(id);
    }

    @Override
    public String getBook(long id) {
        return bookDao.getById(id).toString();
    }
}
