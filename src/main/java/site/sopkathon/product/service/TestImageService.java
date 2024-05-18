package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.sopkathon.product.dto.request.TestImageRequest;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TestImageService {

    private static final String S3_DIRECTORY = "testimages";

    private final S3Service service;


    @Transactional
    public void uploadTestImage(MultipartFile image, TestImageRequest request) {
        try {
            service.uploadImage(S3_DIRECTORY, image);
        } catch (IOException e) {
            log.error("Failed to upload image", e);
        }
    }
}
