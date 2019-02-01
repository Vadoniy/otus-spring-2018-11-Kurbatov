package homework_6.dao.impl;

import homework_6.dao.AuthorRepositoryJpa;
import homework_6.domain.Author;
import homework_6.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryJpaImpl implements AuthorRepositoryJpa {

//    private static final Logger log = LoggerFactory.getLogger(AuthorRepositoryJpaImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getById(long authorId) {
        return em.find(Author.class, authorId);
    }

    @Override
    public Author getByName(String penName) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.penName = :penName", Author.class);
        query.setParameter("penName", penName);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void addAuthor(Author newAuthor) {
        em.persist(newAuthor);
    }

    @Override
    @Transactional
    public void deleteById(long authorId) {
        em.remove(em.find(Author.class, authorId));
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        em.detach(author);
        em.merge(author);
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        return query.getResultList();
    }
}
