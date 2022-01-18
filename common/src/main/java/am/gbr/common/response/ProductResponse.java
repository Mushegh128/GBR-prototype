package am.gbr.common.response;

import am.gbr.common.entity.Brand;
import am.gbr.common.entity.MadeInCountry;
import am.gbr.common.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private Long barcode;
    private String title;
    private String description;
    private Double price;
    private Double weight;
    private String smallPicUrl;
    private String picUrl;
    private LocalDateTime createdDateTime;
    private boolean isActive;
    private MadeInCountry madeInCountry;
    private ProductCategory productCategory;
    private Brand brand;
}
