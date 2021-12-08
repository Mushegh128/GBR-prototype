package am.gbr.common.response;

import am.gbr.common.entity.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private Long serialNumber;
    private UserResponse userResponse;
    private CompanyResponse companyResponse;
    private LocalDateTime createdDateTime;
    private LocalDateTime saleDateTime;
    private Double orderCost;
    private Double debtSize;
    private OrderStatus orderStatus;
    private List<ProductOrderResponse> productOrderResponses;
    private List<PaymentResponse> paymentResponseList;

    public double getOrderCost() {
        productOrderResponses.forEach(productOrderResponse -> orderCost +=
                productOrderResponse.getCount() * productOrderResponse.getProductResponse().getPrice());
        return orderCost;
    }
}
