package site.sopkathon.product.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.sopkathon.product.common.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodHistory extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodTitle;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    private boolean isSuccess = false;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public FoodHistory(String foodTitle, String imageUrl, boolean isSuccess, Member member) {
        this.foodTitle = foodTitle;
        this.imageUrl = imageUrl;
        this.isSuccess = isSuccess;
        this.member = member;
    }
}
