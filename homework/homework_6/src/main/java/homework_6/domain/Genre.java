package homework_6.domain;

import javax.persistence.*;

@Entity
@Table(name = "GENRES")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long genreId;
    @Column
    private String genre;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
//    private List<Book> books;

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

//    public List<Book> getBooks() {
//        return books;
//    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre='" + genre + '\'' +
//                ", books=" + Utils.booksTitlesListToString(books) +
                '}';
    }
}
