package site.sopkathon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.sopkathon.product.domain.FoodHistory;
import site.sopkathon.product.domain.Member;

import java.util.List;

public interface FoodHistoryRepository extends JpaRepository<FoodHistory, Long> {
    List<FoodHistory> findAllByMember(Member member);
}
