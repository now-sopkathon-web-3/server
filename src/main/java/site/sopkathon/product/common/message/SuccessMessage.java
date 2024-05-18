package site.sopkathon.product.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    HEALTH_CHECK_SUCCESS("Health check success"),
    TEST_IMAGE_UPLOAD_SUCCESS("Test image upload success");

    private final String message;
}
