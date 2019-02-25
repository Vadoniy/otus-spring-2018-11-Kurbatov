package homework_7.domain;

import homework_7.util.Utils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long genreId;
    @Column
    private String genre;

    public Genre(){}

    public Genre(String genre){
        this.genre = genre;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genre='" + genre + '\'' +
                '}';
    }
}
