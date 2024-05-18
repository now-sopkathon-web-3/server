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
import site.sopkathon.product.dto.request.member.MemberSignInRequest;
import site.sopkathon.product.dto.request.member.MemberSignUpRequest;
import site.sopkathon.product.dto.response.member.MemberSignInResponse;
import site.sopkathon.product.dto.response.member.MemberSignUpResponse;
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
    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<MemberSignUpResponse>> signUp(
            @RequestBody final MemberSignUpRequest request
            ) {
        final MemberSignUpResponse response = memberService.signUp(request);
        return BaseResponse.created(SuccessMessage.MEMBER_SIGN_UP_SUCCESS, response);
    }

    @Operation(summary = "회원 로그인", description = "회원 로그인을 진행합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "회원 로그인 성공")
            }
    )
    public ResponseEntity<BaseResponse<MemberSignInResponse>> login(
            @RequestBody final MemberSignInRequest request
            ) {
        final MemberSignInResponse response = memberService.login(request);
        return BaseResponse.ok(SuccessMessage.MEMBER_SIGN_IN_SUCCESS, response);
    }

}
