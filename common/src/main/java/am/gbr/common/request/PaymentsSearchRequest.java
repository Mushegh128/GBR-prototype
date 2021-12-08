package am.gbr.common.request;

import am.gbr.common.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsSearchRequest {

    String registerNumber;
    LocalDateTime startLocalDateTime;
    LocalDateTime endLocalDateTime;
    PaymentStatus status;

}
