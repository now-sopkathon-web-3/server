package site.sopkathon.product.dto.response.rank;

import site.sopkathon.product.domain.Member;

public record MemberRankResponse(
        long userId,
        String nickname,
        int foodIslandCount,
        int streak
) {

    public static MemberRankResponse of(Member member) {
        return new MemberRankResponse(
                member.getId(),
                member.getUsername(),
                member.getFoodCount(),
                member.getStreak()
        );
    }
}
