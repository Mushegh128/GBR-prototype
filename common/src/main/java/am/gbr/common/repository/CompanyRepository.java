package am.gbr.common.repository;


import am.gbr.common.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByBarcode(long barcode);

    Optional<Company> findByRegisterNumber(String regNumber);


    List<Company> findByOrderByNameDesc();

    List<Company> findByOrderByNameAsc();

    Optional<Company> findByName(String name);

    List<Company> findAllByPresSeller_Id(Long id);

}
