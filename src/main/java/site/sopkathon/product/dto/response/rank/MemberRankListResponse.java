package site.sopkathon.product.dto.response.rank;

import java.util.List;

public record MemberRankListResponse(
        List<MemberRankResponse> rank
) {

    public static MemberRankListResponse of(List<MemberRankResponse> rank) {
        return new MemberRankListResponse(rank);
    }
}
