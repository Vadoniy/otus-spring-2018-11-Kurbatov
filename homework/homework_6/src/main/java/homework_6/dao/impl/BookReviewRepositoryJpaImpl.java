package homework_6.dao.impl;

import homework_6.dao.BookReviewRepositoryJpa;
import homework_6.domain.Book;
import homework_6.domain.BookReview;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookReviewRepositoryJpaImpl implements BookReviewRepositoryJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BookReview getById(long bookReviewId) {
        return em.find(BookReview.class, bookReviewId);
    }

    @Override
    public BookReview getByBook(Book book) {
        TypedQuery<BookReview> query = em.createQuery("select r from BookReview r where r.book = :book", BookReview.class);
        query.setParameter("book", book);
        return query.getSingleResult();
    }

    @Override
    public List<BookReview> getAll() {
        TypedQuery<BookReview> query = em.createQuery("select r from BookReview", BookReview.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addReview(BookReview newBookReview) {
        em.persist(newBookReview);
    }

    @Override
    @Transactional
    public void deleteReview(BookReview review) {
    }

    @Override
    @Transactional
    public void updateBookReview(BookReview bookReview) {
        em.detach(bookReview);
        em.merge(bookReview);
    }
}
