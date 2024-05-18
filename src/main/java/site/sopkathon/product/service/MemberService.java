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
    public MemberSignUpResponse signUp(final MemberSignUpRequest request) {
        if (!memberRepository.existsByUsername(request.username())) {
            throw new BadRequestException("이미 존재하는 회원입니다.");
        }
        final Member savedMember = memberRepository.save(
                Member.builder()
                        .username(request.username())
                        .build()
        );
        return MemberSignUpResponse.of(savedMember.getId());
    }

    public MemberSignInResponse login(final MemberSignInRequest request) {
        final Member findMember =  memberRepository.findByUsername(request.username())
                .orElseThrow(() -> new BadRequestException("존재하지 않는 회원입니다."));
        return MemberSignInResponse.of(findMember.getId());
    }

}
