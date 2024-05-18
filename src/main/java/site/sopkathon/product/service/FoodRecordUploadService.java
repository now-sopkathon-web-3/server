package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.common.exception.BadRequestException;
import site.sopkathon.product.common.exception.InternalServerErrorException;
import site.sopkathon.product.domain.FoodHistory;
import site.sopkathon.product.domain.Member;
import site.sopkathon.product.dto.request.FoodRecordUploadImageRequest;
import site.sopkathon.product.repository.FoodHistoryRepository;
import site.sopkathon.product.repository.MemberRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodRecordUploadService {

    private static final String S3_DIRECTORY = "images/";
    private final FoodHistoryRepository foodHistoryRepository;
    private final MemberRepository memberRepository;
    private final S3Service service;

    @Transactional
    public void uploadFoodRecord(
            long userId,
            MultipartFile image, FoodRecordUploadImageRequest request
    ) {
        try {
            Member member = memberRepository.findById(userId)
                    .orElseThrow(() -> new BadRequestException("사용자가 존재하지 않습니다. userId: " + userId));

            String url = service.uploadImage(S3_DIRECTORY, image);

            foodHistoryRepository.save(FoodHistory.builder()
                    .foodTitle(request.foodTitle())
                    .member(member)
                    .imageUrl(url)
                    .build());

            member.updateStreak();

            if (member.getStreak() == 30) {
                member.updateFoodCount();
                member.resetStreak();
            }

        } catch (IOException e) {
            throw new InternalServerErrorException("이미지 업로드에 실패했습니다.");
        }
    }


}
