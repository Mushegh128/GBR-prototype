package am.gbr.common.response;

import am.gbr.common.entity.Region;
import am.gbr.common.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private long id;
    private String name;
    private String surname;
    private String email;
    private double rating;
    private Region region;
    private CompanyResponse companyResponse;
    private Role role;
}
