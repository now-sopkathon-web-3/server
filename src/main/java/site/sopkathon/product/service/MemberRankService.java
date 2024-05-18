package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sopkathon.product.domain.Member;
import site.sopkathon.product.dto.response.rank.MemberRankListResponse;
import site.sopkathon.product.dto.response.rank.MemberRankResponse;
import site.sopkathon.product.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRankService {

    private final MemberRepository memberRepository;

    public MemberRankListResponse getMembersRank() {
        List<MemberRankResponse> responses = memberRepository.findAll(Sort.by("foodCount").descending()
                         .and(Sort.by("streak").descending()))
                .stream()
                .map(MemberRankResponse::of)
                .toList();
        return MemberRankListResponse.of(responses);
    }

}
