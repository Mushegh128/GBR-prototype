package am.gbr.common.mapper;

import am.gbr.common.entity.Company;
import am.gbr.common.entity.User;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.UserRequest;
import am.gbr.common.response.CompanyResponse;
import am.gbr.common.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserRequest, UserResponse> {
    private final ModelMapper mapper;

    @Override
    public User toEntity(UserRequest userRequest) {
        User user = mapper.map(userRequest, User.class);
        if (userRequest.getCompanyRequest() != null) {
            user.setCompany(mapper.map(userRequest.getCompanyRequest(), Company.class));
        }
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        userResponse.setCompanyResponse(mapper.map(user.getCompany(), CompanyResponse.class));
        return userResponse;
    }
}
