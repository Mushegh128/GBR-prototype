package am.gbr.common.service;


import am.gbr.common.entity.OrderStatus;
import am.gbr.common.exception.OrderNotFoundException;
import am.gbr.common.request.OrderRequest;
import am.gbr.common.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAllByUserIdAndCompanyId(long userId, long companyId);

    List<OrderResponse> findAllUnSynchronized() throws OrderNotFoundException;

    List<OrderResponse> findAllByOrderStatus(OrderStatus orderStatus);

    List<OrderResponse> findAllByDateRange(String start, String end);

    OrderResponse findBySerialNumber(long serialNumber) throws OrderNotFoundException;

    Double getCompanyDebt(long registerNumber);

    OrderResponse save(OrderRequest orderRequest);

    List<OrderResponse> findAllByCompanyId(Long id);

    OrderResponse updateOrder(OrderRequest order);

    boolean changeOrderStatus(OrderStatus orderStatus, long serialNumber);

    List<OrderResponse> findAll();

    OrderResponse findById(long id);

    List<OrderResponse> findByStatus(OrderStatus ordered);

    void deleteOrderedProductFromOrder(Long productOrderId, Long serialNumber);
}
