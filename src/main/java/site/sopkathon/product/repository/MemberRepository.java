package site.sopkathon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.sopkathon.product.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
