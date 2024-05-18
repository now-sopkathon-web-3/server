package site.sopkathon.product.dto.response.member;

import site.sopkathon.product.domain.Member;

public record MemberInfoResponse(
        long userId,
        int foodIslandCount,
        int streak


) {
    public static MemberInfoResponse of(Member member) {
        return new MemberInfoResponse(member.getId(), member.getFoodCount(), member.getStreak());
    }
}
