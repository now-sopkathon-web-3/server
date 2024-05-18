package site.sopkathon.product.dto.response.rank;

import site.sopkathon.product.domain.Member;

public record MyRankResponse(
        long userId,
        String username,
        int foodIslandCount,
        int streak,
        Integer rank
) {
    public static MyRankResponse of(Member member, int rank) {
        return new MyRankResponse(
                member.getId(),
                member.getUsername(),
                member.getFoodCount(),
                member.getStreak(),
                rank
        );
    }
}
