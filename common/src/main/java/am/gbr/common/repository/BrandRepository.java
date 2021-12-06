package am.gbr.common.repository;


import am.gbr.common.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByTitle(String title);

}
