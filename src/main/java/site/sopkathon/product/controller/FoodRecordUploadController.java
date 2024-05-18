package site.sopkathon.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;
import site.sopkathon.product.dto.request.FoodRecordUploadImageRequest;
import site.sopkathon.product.service.FoodRecordUploadService;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
@Tag(name = "[FoodHistory API]", description = "하루 음식 기록 업로드 API")
public class FoodRecordUploadController {

    private final FoodRecordUploadService foodRecordUploadService;

    @Operation(summary = "기록 업로드", description = "하루 음식 기록을 업로드 합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "하루 음식 기록 업로드 성공")
            }
    )
    @PostMapping
    public ResponseEntity<BaseResponse<Void>> uploadFoodRecord(
            @RequestHeader("Authorization") final long userId,
            @RequestPart MultipartFile image, FoodRecordUploadImageRequest request
    ) {
        foodRecordUploadService.uploadFoodRecord(userId, image, request);
        return BaseResponse.created(SuccessMessage.FOOD_RECORD_UPLOAD_SUCCESS, null);
    }
}
