package homework_6.domain;

import homework_6.util.Utils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bookId;
    @Column
    private String title;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Author author;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Genre> genres;

    public Book() {
    }

    public Book(String title, Author author, List<Genre> genres /*Genre genre*/){
        this.title = title;
        this.author = author;
        this.genres = new ArrayList<>();
        genres.forEach(genre1 -> this.genres.add(genre1));
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGenres(List<Genre> genres) {
        genres.forEach(genre1 -> this.genres.add(genre1));
    }

    public void removeGenre(List<Genre> genres) {
        genres.forEach(genre1 -> this.genres.remove(genre1));
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genres=" + Utils.listToString(genres) +
                '}';
    }
}
