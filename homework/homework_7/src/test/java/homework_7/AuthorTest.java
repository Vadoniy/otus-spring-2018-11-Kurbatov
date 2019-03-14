package homework_7;

import homework_7.repository.AuthorRepository;
import homework_7.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorTest {

    @Autowired private TestEntityManager tem;
    @Autowired private AuthorRepository authorRepository;

    @Test
    public void testAuthor() throws Exception{
        tem.persist(new Author("Author1"));
        Author author1 = authorRepository.findByPenName("Author1");
        assertThat(author1.getPenName()).isEqualTo("Author1");
    }
}
