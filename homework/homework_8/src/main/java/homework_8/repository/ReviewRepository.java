package homework_8.repository;


import homework_8.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();
    Review findById(String id);
    void deleteById(String id);
    Review findByBookTitle(String title);
    List<Review> findByReviewOwner(String penName);
}