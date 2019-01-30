package homework_6;

import homework_6.dao.AuthorRepositoryJpa;
import homework_6.dao.BookRepositoryJpa;
import homework_6.dao.BookReviewRepositoryJpa;
import homework_6.dao.GenreRepositoryJpa;
import homework_6.dao.impl.BookRepositoryJpaImpl;
import homework_6.domain.Author;
import homework_6.domain.Book;
import homework_6.domain.BookReview;
import homework_6.domain.Genre;
import org.h2.tools.Console;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Main.class);
        AuthorRepositoryJpa authorRepository = context.getBean(AuthorRepositoryJpa.class);
        BookRepositoryJpa bookRepository = context.getBean(BookRepositoryJpa.class);
        GenreRepositoryJpa genreRepository = context.getBean(GenreRepositoryJpa.class);
        BookReviewRepositoryJpa bookReviewRepositoryJpa = context.getBean(BookReviewRepositoryJpa.class);
        Author author1 = new Author("Strugatsky Brothers");
        authorRepository.addAuthor(author1);
        Genre genre1 = new Genre("Non-fiction");
        Genre genre2 = new Genre("Classic");
        genreRepository.addGenre(genre1);
        genreRepository.addGenre(genre2);
        List<Genre> genres = new ArrayList<>();
        genres.add(genre1);
        genres.add(genre2);
        Book book1 = new Book("Doomed City", author1, genres);
        bookRepository.addBook(book1);
        BookReview review1 = new BookReview(book1, "Vadoniy", "Social experiment in out of time City");
        bookReviewRepositoryJpa.addReview(review1);
        System.out.println(bookReviewRepositoryJpa.getByBook(book1));
        bookReviewRepositoryJpa.deleteReview(review1);
//        System.out.println(bookReviewRepositoryJpa.getById(5L).toString());
        Console.main(args);
    }
}
