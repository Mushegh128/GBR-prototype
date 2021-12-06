package am.gbr.common.mapper;

import am.gbr.common.entity.Product;
import am.gbr.common.entity.ProductOrder;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.ProductOrderRequest;
import am.gbr.common.response.ProductOrderResponse;
import am.gbr.common.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOrderMapper implements BaseMapper<ProductOrder, ProductOrderRequest, ProductOrderResponse> {
    private final ModelMapper modelMapper;

    @Override
    public ProductOrder toEntity(ProductOrderRequest productOrderRequest) {
        ProductOrder productOrder = modelMapper.map(productOrderRequest, ProductOrder.class);
        productOrder.setProduct(modelMapper.map(productOrderRequest.getProductRequest(), Product.class));
        return productOrder;
    }

    @Override
    public ProductOrderResponse toResponse(ProductOrder productOrder) {
        ProductOrderResponse productOrderResponse = modelMapper.map(productOrder, ProductOrderResponse.class);
        productOrderResponse.setProductResponse(modelMapper.map(productOrder.getProduct(), ProductResponse.class));
        return productOrderResponse;
    }
}
