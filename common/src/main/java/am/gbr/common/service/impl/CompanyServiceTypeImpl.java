package am.gbr.common.service.impl;

import am.gbr.common.entity.CompanyType;
import am.gbr.common.repository.CompanyTypeRepository;
import am.gbr.common.service.CompanyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyServiceTypeImpl implements CompanyTypeService {
    private final CompanyTypeRepository companyTypeRepository;


    @Override
    public List<CompanyType> findAll() {
        return companyTypeRepository.findAll();
    }
}
