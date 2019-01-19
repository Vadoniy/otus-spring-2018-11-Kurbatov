package homework_5.domain;

public class Genre {

    private long id_genre;
    private String genre;

    public Genre(long id_genre, String genre) {
        this.id_genre = id_genre;
        this.genre = genre;
    }

    public long getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
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
                "id_genre=" + id_genre +
                ", genre='" + genre + '\'' +
                '}';
    }
}
