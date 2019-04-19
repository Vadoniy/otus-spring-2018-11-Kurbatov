package homework_10.repository;

import homework_10.domain.manufacture.IngRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngRateRepository extends CrudRepository<IngRate, Long> {
    List<IngRate> findByPizzaId(long pizzaId);
    List<IngRate> findByIngredientId(long ingredientId);
}
