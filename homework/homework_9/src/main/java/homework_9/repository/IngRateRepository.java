package homework_9.repository;

import homework_9.domain.manufacture.IngRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngRateRepository extends CrudRepository<IngRate, Long> {
    List<IngRate> findByPizzaId(long pizzaId);
}
