package am.gbr.common.request;

import am.gbr.common.entity.CompanyType;
import am.gbr.common.entity.Discount;
import am.gbr.common.entity.PresSeller;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRequest {
    private long id;
    private String name;
    private String address;
    private String registerNumber;
    private String logoUrl;
    private double level;
    private double rating;
    private Discount discount;
    private CompanyType companyType;
    private PresSeller presSeller;
}
