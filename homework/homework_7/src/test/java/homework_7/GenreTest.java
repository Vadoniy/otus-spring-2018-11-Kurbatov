package homework_7;


import homework_7.repository.GenreRepository;
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
public class GenreTest {

    @Autowired private TestEntityManager tem;
    @Autowired private GenreRepository genreRepository;

    @Test
    public void testGenre() throws Exception{
        tem.persist(new Genre("Genre1"));
        Genre genre1 = genreRepository.findByGenre("Genre1");
        assertThat(genre1.getGenre()).isEqualTo("Genre1");
    }
}
