package am.gbr.common.mapper;

import am.gbr.common.entity.Payment;
import am.gbr.common.entity.User;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.PaymentRequest;
import am.gbr.common.response.PaymentResponse;
import am.gbr.common.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMapper implements BaseMapper<Payment, PaymentRequest, PaymentResponse> {
    private final ModelMapper mapper;

    @Override
    public Payment toEntity(PaymentRequest paymentRequest) {
        Payment payment = mapper.map(paymentRequest, Payment.class);
        payment.setFromUser(mapper.map(paymentRequest.getUserRequest(), User.class));
        return payment;
    }

    @Override
    public PaymentResponse toResponse(Payment payment) {
        PaymentResponse paymentResponse = mapper.map(payment, PaymentResponse.class);
        paymentResponse.setUserResponse(mapper.map(payment.getFromUser(), UserResponse.class));
        return paymentResponse;
    }
}
