package homework_7.domain;

import homework_7.util.Utils;

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

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", penName='" + penName + '\'' +
                '}';
    }
}
