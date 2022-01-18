package am.gbr.common.response;

import am.gbr.common.entity.CompanyType;
import am.gbr.common.entity.PresSeller;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyResponse {
    private long id;
    private long barcode;
    private String name;
    private String address;
    private String registerNumber;
    private String phoneNumber;
    private String logoUrl;
    private double level;
    private double rating;
    private CompanyType companyType;
    private PresSeller presSeller;
}
