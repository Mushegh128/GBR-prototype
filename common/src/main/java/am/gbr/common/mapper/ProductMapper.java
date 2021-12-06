package am.gbr.common.mapper;

import am.gbr.common.entity.Product;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.ProductRequest;
import am.gbr.common.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper implements BaseMapper<Product, ProductRequest, ProductResponse> {
    private final ModelMapper mapper;

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return mapper.map(productRequest, Product.class);
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return mapper.map(product, ProductResponse.class);
    }
}
