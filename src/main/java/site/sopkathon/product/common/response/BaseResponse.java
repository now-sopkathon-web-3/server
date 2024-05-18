package site.sopkathon.product.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import site.sopkathon.product.common.message.SuccessMessage;

public record BaseResponse<T>(
        String message,
        T data
) {

    public static ResponseEntity<BaseResponse<Void>> ok(SuccessMessage successMessage) {
        return ResponseEntity.ok(new BaseResponse<Void>(successMessage.getMessage(), null));
    }

    public static <T> ResponseEntity<BaseResponse<T>> ok(SuccessMessage successMessage, T data) {
        return ResponseEntity.ok( new BaseResponse<T>(successMessage.getMessage(),data));
    }

    public static <T> ResponseEntity<BaseResponse<T>> created(SuccessMessage successMessage, T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<T>(successMessage.getMessage(),data));
    }

    public static ResponseEntity<BaseResponse<Void>> created(SuccessMessage successMessage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<Void>(successMessage.getMessage(), null));
    }

    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<T>(message, null);
    }

}