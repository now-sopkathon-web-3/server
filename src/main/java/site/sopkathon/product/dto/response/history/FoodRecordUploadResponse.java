package site.sopkathon.product.dto.response.history;

public record FoodRecordUploadResponse(
) {

    //static method
    public static FoodRecordUploadResponse of() {
        return new FoodRecordUploadResponse();
    }
}
