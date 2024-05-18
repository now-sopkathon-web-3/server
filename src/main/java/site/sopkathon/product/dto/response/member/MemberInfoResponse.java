package site.sopkathon.product.dto.response.member;

public record MemberInfoResponse(
        long userId,
        int foodIslandCount,
        int streak


) {
    public static MemberInfoResponse of(long userId, int foodIslandCount, int streak) {
        return new MemberInfoResponse(userId, foodIslandCount, streak);
    }
}
