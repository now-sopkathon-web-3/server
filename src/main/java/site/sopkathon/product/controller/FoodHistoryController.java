package site.sopkathon.product.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;
import site.sopkathon.product.dto.response.history.HistoryListResponse;
import site.sopkathon.product.service.FoodHistoryService;

@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
@Tag(name = "[FoodHistory API]", description = "나의 history 목록 조회 API")
public class FoodHistoryController {

    private final FoodHistoryService historyService;

    @Operation(summary = "나의 히스토리 목족 조회 API", description = "하루 음식 기록을 업로드 합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "하루 음식 기록 업로드 성공")
            }
    )
    @GetMapping
    public ResponseEntity<BaseResponse<HistoryListResponse>> getHistories(
            @RequestHeader("Authorization") final long userId
    ) {
        historyService.getHistories(userId);
        return BaseResponse.ok(SuccessMessage.GET_HISTORY_LIST_SUCCESS,historyService.getHistories(userId));
    }
}
