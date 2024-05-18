package site.sopkathon.product.dto.response.rank;

import java.util.List;

public record MemberRankListResponse(
        MyRankResponse myRank,
        List<MemberRankResponse> rank
) {

    public static MemberRankListResponse of(MyRankResponse myRank, List<MemberRankResponse> rank) {
        return new MemberRankListResponse(myRank, rank);
    }
}
