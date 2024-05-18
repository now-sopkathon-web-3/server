package site.sopkathon.product.dto.response.member;

public record MemberSignUpResponse(
        long userId
) {

    public static MemberSignUpResponse of(long userId) {
        return new MemberSignUpResponse(userId);
    }
}
