package site.sopkathon.product.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    HEALTH_CHECK_SUCCESS("Health check success"),
    MEMBER_SIGN_UP_SUCCESS("사용자 회원가입 성공"),
    MEMBER_SIGN_IN_SUCCESS("사용자 로그인 성공"),
    GET_HISTORY_LIST_SUCCESS("사용자 히스토리 목록 조회 성공"),
    TEST_IMAGE_UPLOAD_SUCCESS("Test image upload success"),
    FOOD_RECORD_UPLOAD_SUCCESS("하루 음식 기록 업로드 성공");

    private final String message;
}
