package site.sopkathon.product.dto.request.history;

public record FoodRecordUploadRequest(
        String foodTitle,
        Boolean isSuccess
) {
}
