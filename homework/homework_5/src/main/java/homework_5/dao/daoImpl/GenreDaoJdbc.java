package homework_5.dao.daoImpl;

import homework_5.dao.GenreDao;
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
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbcOps;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbcOps) {
        this.jdbcOps = jdbcOps;
    }

    @Override
    public int count() {
        return jdbcOps.queryForObject("SELECT count(*) FROM GENRES", new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        final Map<String, String> mapParams = new HashMap<>();
        mapParams.put("id", String.valueOf(genre.getId_genre()));
        mapParams.put("genre", genre.getGenre());
        jdbcOps.update("INSERT INTO GENRES (ID_GENRE, GENRE) VALUES (:id, :genre)", mapParams);
    }

    @Override
    public Genre getById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        return jdbcOps.queryForObject("SELECT * FROM GENRES WHERE ID_GENRE = :id", mapParams, new GenreMapper());
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        jdbcOps.update("DELETE FROM GENRES WHERE ID_GENRE = :id", mapParams);
    }

    @Override
    public List<Genre> getAll() {
        return jdbcOps.query("SELECT * FROM GENRES", new GenreMapper());
    }

    private class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("ID_GENRE");
            String genre = rs.getString("GENRE");
            return new Genre(id, genre);
        }
    }
}
