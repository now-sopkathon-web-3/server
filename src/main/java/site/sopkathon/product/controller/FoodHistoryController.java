package site.sopkathon.product.controller;


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
public class FoodHistoryController {

    private final FoodHistoryService historyService;

    @GetMapping
    public ResponseEntity<BaseResponse<HistoryListResponse>> getHistories(
            @RequestHeader("Authorization") final long memberId
    ) {
        historyService.getHistories(memberId);
        return BaseResponse.ok(SuccessMessage.GET_HISTORY_LIST_SUCCESS,historyService.getHistories(memberId));
    }
}
