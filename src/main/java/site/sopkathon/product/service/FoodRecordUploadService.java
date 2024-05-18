package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.common.exception.InternalServerErrorException;
import site.sopkathon.product.dto.request.FoodRecordUploadImageRequest;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodRecordUploadService {

        private static final String S3_DIRECTORY = "testimages/";

        private final S3Service service;

        @Transactional
        public void uploadFoodRecord(
                MultipartFile image, FoodRecordUploadImageRequest request
    ) {
            try {
                service.uploadImage(S3_DIRECTORY, image);
            } catch (IOException e) {
                throw new InternalServerErrorException("이미지 업로드에 실패했습니다.");
            }
        }

}
