package am.gbr.common.repository;

import am.gbr.common.entity.Listing;
import am.gbr.common.entity.ListingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findAllByListingStatus(ListingStatus status);
}
