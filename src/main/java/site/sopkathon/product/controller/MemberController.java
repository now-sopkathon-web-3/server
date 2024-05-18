package site.sopkathon.product.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;
import site.sopkathon.product.dto.request.member.GetMyInfoRequest;
import site.sopkathon.product.dto.request.member.MemberSignInRequest;
import site.sopkathon.product.dto.response.member.MemberInfoResponse;
import site.sopkathon.product.dto.response.member.MemberSignInResponse;
import site.sopkathon.product.service.MemberService;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Tag(name = "[Member API]", description = "회원 관련")
public class MemberController {

    private final MemberService memberService;


    @Operation(summary = "회원 가입", description = "회원 가입을 진행합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "회원 가입 성공")
            }
    )
    @PostMapping("/auth")
    public ResponseEntity<BaseResponse<MemberSignInResponse>> signUp(
            @RequestBody final MemberSignInRequest request
    ) {
        final MemberSignInResponse response = memberService.signUp(request);
        return BaseResponse.created(SuccessMessage.MEMBER_SIGN_UP_SUCCESS, response);
    }

    @Operation(summary = "내 정보 조회", description = "나의 카운트 값과 연속일 수를 조회합니다.")
    @GetMapping
    public ResponseEntity<BaseResponse<MemberInfoResponse>> getMyInfo(
            @RequestHeader("Authorization") final long userId
    ) {
        MemberInfoResponse memberInfo = memberService.getMyInfo(userId);

        return BaseResponse.ok(SuccessMessage.GET_MY_INFO_SUCCESS, memberInfo);
    }
}
