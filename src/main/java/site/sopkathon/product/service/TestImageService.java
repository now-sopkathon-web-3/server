package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.dto.request.TestImageRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestImageService {

    private final S3Service service;


    @Transactional

    public void uploadTestImage(MultipartFile image, TestImageRequest request) {

    }
}
