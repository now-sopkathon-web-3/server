package site.sopkathon.product.dto.response.history;

import site.sopkathon.product.domain.FoodHistory;

import java.time.LocalDateTime;

public record HistoryResponse(
        LocalDateTime createdAt,
        String foodTitle,
        String imageUrl
) {

    // static method
    public static HistoryResponse of(FoodHistory history) {
        return new HistoryResponse(history.getCreatedAt(), history.getFoodTitle(), history.getImageUrl());
    }
}
