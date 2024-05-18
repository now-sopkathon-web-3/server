package site.sopkathon.product.dto.request.member;

public record GetMyInfoRequest(
        long userId,
        int foodCount,
        int streak
) {
}
