package am.gbr.common.service;

import am.gbr.common.entity.PaymentStatus;
import am.gbr.common.request.PaymentRequest;
import am.gbr.common.request.PaymentsSearchRequest;
import am.gbr.common.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    PaymentResponse save(PaymentRequest paymentRequest);

    List<PaymentResponse> findAllByCompanyRegisterNumber(String id);

    List<PaymentResponse> findAllByFromUser(Long id);

    PaymentResponse setPaymentStatusBySerialNumber(PaymentStatus paymentStatus, String serialNumber);

    List<PaymentResponse> findByStatus(PaymentStatus created);

    List<PaymentResponse> search(PaymentsSearchRequest paymentsSearchRequest);
}
