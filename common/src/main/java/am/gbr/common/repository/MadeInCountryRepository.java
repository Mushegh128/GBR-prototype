package am.gbr.common.repository;

import am.gbr.common.entity.MadeInCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MadeInCountryRepository extends JpaRepository<MadeInCountry, Long> {

    MadeInCountry findByTitle(String title);
}
