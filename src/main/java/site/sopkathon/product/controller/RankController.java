package site.sopkathon.product.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;
import site.sopkathon.product.dto.response.rank.MemberRankListResponse;
import site.sopkathon.product.service.MemberRankService;

@RestController("/members/rank")
@RequiredArgsConstructor
@Tag(name = "[Rank API]", description = "랭킹 관련")
public class RankController {

    private final MemberRankService memberRankService;

    @GetMapping
    @Operation(summary = "랭킹 조회", description = "랭킹을 조회합니다.")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "랭킹 조회 성공"),
            @ApiResponse(responseCode = "500", description = "알수 없는 에러")
    )
    public ResponseEntity<BaseResponse<MemberRankListResponse>> getMembersRank() {
        return BaseResponse.ok(SuccessMessage.GET_RANK_SUCCESS, memberRankService.getMembersRank());
    }

}
