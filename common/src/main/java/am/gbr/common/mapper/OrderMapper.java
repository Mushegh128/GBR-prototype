package am.gbr.common.mapper;


import am.gbr.common.entity.Order;
import am.gbr.common.entity.Payment;
import am.gbr.common.entity.ProductOrder;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.OrderRequest;
import am.gbr.common.request.ProductOrderRequest;
import am.gbr.common.response.OrderResponse;
import am.gbr.common.response.PaymentResponse;
import am.gbr.common.response.ProductOrderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderMapper implements BaseMapper<Order, OrderRequest, OrderResponse> {
    private final ModelMapper mapper;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final PaymentMapper paymentMapper;
    private final ProductOrderMapper productOrderMapper;

    @Override
    public Order toEntity(OrderRequest orderRequest) {
        List<ProductOrder> productOrders = new LinkedList<>();
        for (ProductOrderRequest productOrderRequest : orderRequest.getProductOrderRequests()) {
            productOrders.add(productOrderMapper.toEntity(productOrderRequest));
        }
        Order order = mapper.map(orderRequest, Order.class);
        order.setProductOrders(productOrders);
        order.setCompany(companyMapper.toEntity(orderRequest.getCompanyRequest()));
        order.setUser(userMapper.toEntity(orderRequest.getUserRequest()));
        return order;
    }

    @Override
    public OrderResponse toResponse(Order order) {
        List<PaymentResponse> paymentResponseList = new LinkedList<>();
        List<ProductOrderResponse> productOrderResponseList = new LinkedList<>();
        for (ProductOrder productOrder : order.getProductOrders()) {
            productOrderResponseList.add(productOrderMapper.toResponse(productOrder));
        }
        for (Payment payment : order.getPaymentList()) {
            paymentResponseList.add(paymentMapper.toResponse(payment));
        }
        OrderResponse orderResponse = mapper.map(order, OrderResponse.class);
        orderResponse.setProductOrderResponses(productOrderResponseList);
        orderResponse.setCompanyResponse(companyMapper.toResponse(order.getCompany()));
        orderResponse.setUserResponse(userMapper.toResponse(order.getUser()));
        orderResponse.setPaymentResponseList(paymentResponseList);
        return orderResponse;
    }
}
