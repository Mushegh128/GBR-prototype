package am.gbr.common.repository;

import am.gbr.common.entity.ListingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingCategoryRepository extends JpaRepository<ListingCategory, Long> {
}
