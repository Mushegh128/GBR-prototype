package am.gbr.common.mapper;

import am.gbr.common.entity.Company;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.CompanyRequest;
import am.gbr.common.response.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyMapper implements BaseMapper<Company, CompanyRequest, CompanyResponse> {
    private final ModelMapper mapper;

    @Override
    public Company toEntity(CompanyRequest companyRequest) {
        return mapper.map(companyRequest, Company.class);
    }

    @Override
    public CompanyResponse toResponse(Company company) {
        return mapper.map(company, CompanyResponse.class);
    }
}
