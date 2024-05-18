package site.sopkathon.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;
import site.sopkathon.product.dto.request.TestImageRequest;
import site.sopkathon.product.service.TestImageService;

@RestController
@RequiredArgsConstructor
@Tag(name = "[Test Image]", description = "테스트 이미지 업로드")
public class TestImageController {

    private final TestImageService testImageService;

    @Operation(summary = "테스트 이미지 업로드")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "테스트 이미지 업로드 성공"),
                    @ApiResponse(responseCode = "500", description = "테스트 이미지 업로드 실패")
            }
    )
    @PostMapping("/image/test")
    public ResponseEntity<BaseResponse<Void>> uploadImageTest(
            @RequestPart MultipartFile image, TestImageRequest request
            ) {
        testImageService.uploadTestImage(image, request);
        return BaseResponse.ok(SuccessMessage.HEALTH_CHECK_SUCCESS, null);
    }

}
