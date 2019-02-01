package homework_6.domain;

import homework_6.util.Utils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long authorId;
    @Column
    private String penName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Book> books;

    public Author(){}

    public Author(String penName){
        this.penName = penName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "penName='" + penName + '\'' +
                ", books=" + Utils.booksTitlesListToString(books) +
                '}';
    }
}
