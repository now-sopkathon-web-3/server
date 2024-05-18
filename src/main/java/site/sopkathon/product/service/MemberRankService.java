package site.sopkathon.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sopkathon.product.common.exception.BadRequestException;
import site.sopkathon.product.domain.Member;
import site.sopkathon.product.dto.response.rank.MemberRankListResponse;
import site.sopkathon.product.dto.response.rank.MemberRankResponse;
import site.sopkathon.product.dto.response.rank.MyRankResponse;
import site.sopkathon.product.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRankService {

    private final MemberRepository memberRepository;

    public MemberRankListResponse getMembersRank(final long userId) {
        final Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("사용자가 존재하지 않습니다. userId: " + userId));

        Integer myRank = 0;
        List<MemberRankResponse> responses = memberRepository.findAll(Sort.by("foodCount").descending()
                         .and(Sort.by("streak").descending()))
                .stream()
                .map(MemberRankResponse::of)
                .toList();

        for (int i = 0; i < responses.size(); i++ ) {
            if (responses.get(i).userId() == member.getId()) {
                myRank = i + 1;
                break;
            }
        }
        MyRankResponse myRankResponse = MyRankResponse.of(member, myRank);
        return MemberRankListResponse.of(myRankResponse, responses);
    }

}
