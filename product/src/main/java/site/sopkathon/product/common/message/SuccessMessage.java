package site.sopkathon.product.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  SuccessMessage {
    HEALTH_CHECK_SUCCESS("Health check success");

    private final String message;
}
