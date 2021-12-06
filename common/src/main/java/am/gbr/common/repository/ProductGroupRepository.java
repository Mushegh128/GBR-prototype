package am.gbr.common.repository;


import am.gbr.common.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

    ProductGroup findByTitle(String title);
}
