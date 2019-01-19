package homework_5.domain;

public class Author {

    private long id_author;
    private String pen_name;

    public Author(long id, String pen_name) {
        this.id_author = id;
        this.pen_name = pen_name;
    }

    public long getId_author() {
        return id_author;
    }

    public String getPen_name() {
        return pen_name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + id_author +
                ", pen_name='" + pen_name + '\'' +
                '}';
    }
}
