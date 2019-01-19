package homework_5.dao.daoImpl;

import homework_5.dao.AuthorDao;
import homework_5.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbcOps;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOps) {
        this.jdbcOps = jdbcOps;
    }

    @Override
    public int count() {
        return jdbcOps.queryForObject("SELECT count(*) FROM AUTHORS", new HashMap<>(), Integer.class);
    }

    @Override
    public void insert(Author author) {
        final Map<String, String> mapParams = new HashMap<>();
        mapParams.put("id", String.valueOf(author.getId_author()));
        mapParams.put("name",author.getPen_name());
        jdbcOps.update("INSERT INTO AUTHORS (ID_AUTHOR, PEN_NAME) VALUES (:id, :name)", mapParams);
    }

    @Override
    public Author getById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        return jdbcOps.queryForObject("SELECT * FROM AUTHORS WHERE ID_AUTHOR = :id", mapParams, new AuthorMapper());
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Long> mapParams = new HashMap<>();
        mapParams.put("id", id);
        jdbcOps.update("DELETE FROM AUTHORS WHERE ID_AUTHOR = :id", mapParams);
    }

    @Override
    public List<Author> getAll() {
        return jdbcOps.query("SELECT * FROM AUTHORS", new AuthorMapper());
    }

    private class AuthorMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("ID_AUTHOR");
            String pen_name = rs.getString("PEN_NAME");
            return new Author(id, pen_name);
        }
    }
}
