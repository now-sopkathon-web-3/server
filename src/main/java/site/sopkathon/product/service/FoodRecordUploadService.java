package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.common.exception.InternalServerErrorException;
import site.sopkathon.product.domain.FoodHistory;
import site.sopkathon.product.dto.request.FoodRecordUploadImageRequest;
import site.sopkathon.product.repository.FoodHistoryRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodRecordUploadService {

        private static final String S3_DIRECTORY = "images/";
        private final FoodHistoryRepository foodHistoryRepository;

        private final S3Service service;

        @Transactional
        public void uploadFoodRecord(
                MultipartFile image, FoodRecordUploadImageRequest request
    ) {
            foodHistoryRepository.save(FoodHistory.builder()
                    .foodTitle(request.foodTitle())
                    .build());

            try {
                service.uploadImage(S3_DIRECTORY, image);
            } catch (IOException e) {
                throw new InternalServerErrorException("이미지 업로드에 실패했습니다.");
            }
        }

}
