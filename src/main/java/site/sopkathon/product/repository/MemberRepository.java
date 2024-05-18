package site.sopkathon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.sopkathon.product.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUsername(String username);

    Optional<Member> findByUsername(String username);
}
