package am.gbr.common.request;

import am.gbr.common.entity.Brand;
import am.gbr.common.entity.MadeInCountry;
import am.gbr.common.entity.ProductCategory;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private long id;
    private Long barcode;
    private String title;
    private String description;
    private Double price;
    private Double weight;
    private MadeInCountry madeInCountry;
    private ProductCategory productCategory;
    private Brand brand;
}
