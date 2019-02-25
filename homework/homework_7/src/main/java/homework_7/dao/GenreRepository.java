package homework_7.dao;

import homework_7.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByGenre(String genre);
}
