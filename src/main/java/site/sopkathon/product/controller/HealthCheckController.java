package site.sopkathon.product.controller;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;

@RestController
@RequestMapping("/health")
@Tag(name = "Health Check", description = "서버 상태 체크")
public class HealthCheckController {

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "서버 상태 체크 성공")
            }
    )
    @GetMapping
    public ResponseEntity<BaseResponse<Void>> healthCheck() {
        return ResponseEntity.ok(BaseResponse.success(SuccessMessage.HEALTH_CHECK_SUCCESS));
    }
}
