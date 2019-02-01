package homework_6.dao;

import homework_6.domain.Book;

import java.util.List;

public interface BookRepositoryJpa {
    Book getById(long bookId);
    Book getByName(String title);
    void addBook(Book newBook);
    void deleteById(long bookId);
    void updateBook(Book book);
    List<Book> getAll();
}
