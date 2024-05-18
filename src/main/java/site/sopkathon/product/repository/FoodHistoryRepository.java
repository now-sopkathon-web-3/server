package site.sopkathon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.sopkathon.product.domain.FoodHistory;

public interface FoodHistoryRepository extends JpaRepository<FoodHistory, Long> {
}
