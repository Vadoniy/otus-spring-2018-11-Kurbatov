package homework_7.domain;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long reviewId;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Book book;
    @Column
    private String review;
    @Column
    private String reviewOwner;

    public BookReview(){}

    public BookReview(Book book, String reviewOwner, String review){
        this.book = book;
        this.reviewOwner = reviewOwner;
        this.review = review;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewOwner() {
        return reviewOwner;
    }

    public void setReviewOwner(String reviewOwner) {
        this.reviewOwner = reviewOwner;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "reviewId=" + reviewId +
                ", book=" + book.getTitle() +
                ", review='" + review + '\'' +
                ", reviewOwner='" + reviewOwner + '\'' +
                '}';
    }
}
