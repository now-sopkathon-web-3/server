package site.sopkathon.product.dto.response.history;

import java.util.List;

public record HistoryListResponse(
        List<HistoryResponse> histories
) {
    public static HistoryListResponse of(List<HistoryResponse> histories) {
        return new HistoryListResponse(histories);
    }

}
