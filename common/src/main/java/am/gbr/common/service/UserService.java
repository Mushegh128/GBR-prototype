package am.gbr.common.service;

import am.gbr.common.request.UserAuthRequest;
import am.gbr.common.request.UserRequest;
import am.gbr.common.response.UserAuthResponse;
import am.gbr.common.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse registration(UserRequest userRequest, String registerNumber);

    boolean verifyUser(String email, String token);

    List<UserResponse> findAllByCompanyId(Long id);

    void update(UserRequest userRequest, long id);

    UserAuthResponse auth(UserAuthRequest userAuthRequest);

}
