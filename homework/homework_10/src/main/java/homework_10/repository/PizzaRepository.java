package homework_10.repository;

import homework_10.domain.manufacture.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {

    List<Pizza> findAll();
}
