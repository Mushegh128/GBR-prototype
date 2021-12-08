package am.gbr.common.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PaymentRequest {
    private Double size;
    private UserRequest userRequest;
    private Long companyRegisterNumber;
}
