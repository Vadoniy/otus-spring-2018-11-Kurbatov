package homework_8.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;
    private Book book;
    private String review;
    private String reviewOwner;

    public Review(Book book, String review, String reviewOwner) {
        this.book = book;
        this.review = review;
        this.reviewOwner = reviewOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", book=" + book.getTitle() +
                ", review='" + review + '\'' +
                ", reviewOwner='" + reviewOwner + '\'' +
                '}';
    }
}
