package homework_7;


import homework_7.dao.AuthorRepository;
import homework_7.dao.BookRepository;
import homework_7.dao.GenreRepository;
import homework_7.dao.ReviewRepository;
import homework_7.domain.Author;
import homework_7.domain.Book;
import homework_7.domain.BookReview;
import homework_7.domain.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookReviewTest {

    @Autowired private TestEntityManager tem;
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;
    @Autowired private GenreRepository genreRepository;
    @Autowired private ReviewRepository reviewRepository;

    @Test
    public void testReview() throws Exception{
        authorRepository.save(new Author("Author1"));
        genreRepository.save(new Genre("Genre1"));
        Author author1 = authorRepository.findByPenName("Author1");
        Genre genre1 = genreRepository.findByGenre("Genre1");
        bookRepository.save(new Book("Book1", author1, genre1));
        Book book1 = bookRepository.findByTitle("Book1");
        tem.persist(new BookReview(book1, "Vadoniy", "Review"));
        BookReview review1 = reviewRepository.findByBook(book1);
        assertThat(review1.getBook().getTitle()).isEqualTo("Book1");
        assertThat(review1.getReviewOwner()).isEqualTo("Vadoniy");
        assertThat(review1.getReview()).isEqualTo("Review");

    }
}
