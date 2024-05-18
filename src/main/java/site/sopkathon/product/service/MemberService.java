package site.sopkathon.product.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sopkathon.product.common.exception.BadRequestException;
import site.sopkathon.product.domain.Member;
import site.sopkathon.product.dto.request.member.MemberSignInRequest;
import site.sopkathon.product.dto.request.member.MemberSignUpRequest;
import site.sopkathon.product.dto.response.member.MemberSignInResponse;
import site.sopkathon.product.dto.response.member.MemberSignUpResponse;
import site.sopkathon.product.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSignInResponse signUp(final MemberSignInRequest request) {
        final Member findMember =  memberRepository.findByUsername(request.username())
                .orElse(
                        memberRepository.save(Member.builder()
                                        .username(request.username())
                                        .build()
                ));
        return MemberSignInResponse.of(findMember.getId());
    }

}
