package homework_6.dao.impl;

import homework_6.dao.GenreRepositoryJpa;
import homework_6.domain.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryJpaImpl implements GenreRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getById(long genreId) {
        return em.find(Genre.class, genreId);
    }

    @Override
    public Genre getByName(String genre) {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g where g.genre = :genre", Genre.class);
        query.setParameter("genre", genre);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void addGenre(Genre newGenre) {
        em.persist(newGenre);
    }

    @Override
    @Transactional
    public void deleteById(long genreId) {

    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        em.detach(genre);
        em.merge(genre);
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }
}
