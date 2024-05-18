package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sopkathon.product.common.exception.BadRequestException;
import site.sopkathon.product.domain.Member;
import site.sopkathon.product.dto.response.history.HistoryListResponse;
import site.sopkathon.product.dto.response.history.HistoryResponse;
import site.sopkathon.product.repository.FoodHistoryRepository;
import site.sopkathon.product.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodHistoryService {

    private final FoodHistoryRepository historyRepository;
    private final MemberRepository memberRepository;

    public HistoryListResponse getHistories(final long memberId) {
        final Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BadRequestException("사용자가 존재하지 않습니다. memberId: " + memberId));

        List<HistoryResponse> histories = historyRepository.findAllByMember(member)
                .stream()
                .map(HistoryResponse::of)
                .toList();
        return HistoryListResponse.of(histories);
    }
}
