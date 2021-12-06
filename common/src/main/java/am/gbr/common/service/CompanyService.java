package am.gbr.common.service;


import am.gbr.common.exception.CompanyNotFoundException;
import am.gbr.common.request.CompanyRequest;
import am.gbr.common.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    CompanyResponse findById(Long id);

    List<CompanyResponse> findByOrderByNameDesc();

    List<CompanyResponse> findByOrderByNameAsc();

    CompanyResponse findByName(String name);

    void deactivatePresSeller(CompanyRequest companyRequest);

    void saveCompany(CompanyRequest companyRequest);

    void update(CompanyRequest companyRequest) throws CompanyNotFoundException;

    CompanyResponse findByRegisterNumber(String registerNumber);

    List<CompanyResponse> findAll();

    List<CompanyResponse> findAllByPresSellerId(Long id);
}
