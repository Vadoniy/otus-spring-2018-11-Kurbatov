package homework_6.dao.impl;

import homework_6.dao.BookRepositoryJpa;
import homework_6.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book getById(long bookId) {
        return em.find(Book.class, bookId);
    }

    @Override
    public Book getByName(String title) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.title = :title", Book.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void addBook(Book newBook) {
        em.persist(newBook);
    }

    @Override
    @Transactional
    public void deleteById(long bookId) {

    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        em.detach(book);
        em.merge(book);
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }
}
