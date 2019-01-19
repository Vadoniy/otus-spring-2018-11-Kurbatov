package homework_5.dao.daoImpl;

import homework_5.dao.AuthorDao;
import homework_5.dao.BookDao;
import homework_5.dao.GenreDao;
import homework_5.domain.Author;
import homework_5.domain.Book;
import homework_5.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOps;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOps) {
        this.jdbcOps = jdbcOps;
    }

    @Override
    public int count() {
        return jdbcOps.queryForObject("SELECT count(*) FROM BOOKS", new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Book book, Author author, Genre genre) {
        final Map<String, String> mapParams = new HashMap<>();
        mapParams.put("id", String.valueOf(book.getId_book()));
        mapParams.put("title",book.getBook_name());
        mapParams.put("id_author", String.valueOf(author.getId_author()));
        mapParams.put("id_genre", String.valueOf(genre.getId_genre()));
        jdbcOps.update("INSERT INTO BOOKS (ID_BOOK, TITLE) VALUES (:id, :title)", mapParams);
        jdbcOps.update("INSERT INTO BOOKS_AUTHORS (ID_BOOK, ID_AUTHOR) VALUES (:id, :id_author)", mapParams);
        jdbcOps.update("INSERT INTO BOOKS_GENRES (ID_BOOK, ID_GENRE) VALUES (:id, :id_genre)", mapParams);
    }

    @Override
    public Book getById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        return jdbcOps.queryForObject("SELECT bb.id_book, bb.title, aa.pen_name, gg.genre\n" +
                "FROM books bb\n" +
                "JOIN books_authors ba\n" +
                "ON bb.id_book = ba.id_book\n" +
                "JOIN authors aa\n" +
                "ON aa.id_author = ba.id_author\n" +
                "JOIN books_genres bg\n" +
                "ON bb.id_book = bg.id_book\n" +
                "JOIN genres gg\n" +
                "ON gg.id_genre = bg.id_genre\n" +
                "WHERE bb.id_book = :id", mapParams, new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        jdbcOps.update("DELETE FROM BOOKS WHERE ID_BOOK = :id", mapParams);
        jdbcOps.update("DELETE FROM BOOKS_AUTHORS WHERE ID_BOOK = :id", mapParams);
        jdbcOps.update("DELETE FROM BOOKS_GENRES WHERE ID_BOOK = :id", mapParams);
    }

    @Override
    public List<Book> getAll() {
        return jdbcOps.query("SELECT bb.id_book, bb.title, aa.pen_name, gg.genre\n" +
                "FROM books bb\n" +
                "JOIN books_authors ba\n" +
                "ON bb.id_book = ba.id_book\n" +
                "JOIN authors aa\n" +
                "ON aa.id_author = ba.id_author\n" +
                "JOIN books_genres bg\n" +
                "ON bb.id_book = bg.id_book\n" +
                "JOIN genres gg\n" +
                "ON gg.id_genre = bg.id_genre", new BookMapper());
    }

    private class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("ID_BOOK");
            String title = rs.getString("TITLE");
            return new Book(id, title);
        }
    }
}
