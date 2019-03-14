package homework_7;

import homework_7.repository.AuthorRepository;
import homework_7.repository.BookRepository;
import homework_7.repository.GenreRepository;
import homework_7.domain.Author;
import homework_7.domain.Book;
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
public class BookTest {

    @Autowired private TestEntityManager tem;
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;
    @Autowired private GenreRepository genreRepository;


    @Test
    public void testBook() throws Exception{
        authorRepository.save(new Author("Author1"));
        genreRepository.save(new Genre("Genre1"));
        Author author1 = authorRepository.findByPenName("Author1");
        Genre genre1 = genreRepository.findByGenre("Genre1");
        tem.persist(new Book("Book1", author1, genre1));
        Book book1 = bookRepository.findByTitle("Book1");
        assertThat(book1.getTitle()).isEqualTo("Book1");
        assertThat(book1.getAuthor().getPenName()).isEqualTo("Author1");
        assertThat(book1.getGenre().getGenre()).isEqualTo("Genre1");
    }
}
