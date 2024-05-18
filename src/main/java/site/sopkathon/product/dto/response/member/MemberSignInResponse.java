package site.sopkathon.product.dto.response.member;

public record MemberSignInResponse(
        long userId
) {
    public static MemberSignInResponse of(long userId) {
        return new MemberSignInResponse(userId);
    }
}
