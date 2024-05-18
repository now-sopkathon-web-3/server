package site.sopkathon.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.sopkathon.product.common.entity.BaseTimeEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    private int streak = 0;
    private int foodCount = 0;


    @Builder
    public Member(String username) {
        this.username = username;
    }

    public void updateStreak() {
        this.streak++;
    }

    public void updateFoodCount() {
        this.foodCount++;
    }

    public void resetStreak() {
        this.streak = 0;
    }
}
