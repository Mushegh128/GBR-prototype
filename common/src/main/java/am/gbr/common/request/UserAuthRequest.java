package am.gbr.common.request;

import lombok.Data;

@Data
public class UserAuthRequest {
    private String email;
    private String password;

}
