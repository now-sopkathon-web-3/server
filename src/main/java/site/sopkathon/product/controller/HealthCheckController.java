package site.sopkathon.product.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sopkathon.product.common.message.SuccessMessage;
import site.sopkathon.product.common.response.BaseResponse;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<BaseResponse<Void>> healthCheck() {
        return ResponseEntity.ok(BaseResponse.success(SuccessMessage.HEALTH_CHECK_SUCCESS));
    }
}
