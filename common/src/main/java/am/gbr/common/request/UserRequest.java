package am.gbr.common.request;

import am.gbr.common.entity.Region;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String passportId;
    private boolean isMailVerified;
    private boolean isContractVerified;
    private Region region;
    private CompanyRequest companyRequest;
}
