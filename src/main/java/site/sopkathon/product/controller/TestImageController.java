package site.sopkathon.product.controller;

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
public class TestImageController {

    private final TestImageService testImageService;

    @PostMapping("/image/test")
    public ResponseEntity<BaseResponse<Void>> uploadImageTest(
            @RequestPart MultipartFile image, TestImageRequest request
            ) {
        return BaseResponse.success(SuccessMessage.HEALTH_CHECK_SUCCESS, null);
    }

}
