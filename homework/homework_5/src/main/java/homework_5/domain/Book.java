package homework_5.domain;

public class Book {

    private long id_book;
    private String book_name;
//    private long authorId;
//    private long genreId;

    public Book(long id_book, String book_name/*, Author authorId, Genre genreId*/) {
        this.id_book = id_book;
        this.book_name = book_name;
//        this.authorId = authorId.getId_author();
//        this.genreId = genreId.getId_genre();
    }

    public long getId_book() {
        return id_book;
    }

    public String getBook_name() {
        return book_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id_book=" + id_book +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
