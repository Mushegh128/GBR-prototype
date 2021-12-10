package am.gbr.common.service;

import am.gbr.common.entity.ListingStatus;
import am.gbr.common.response.ListingResponse;

import java.util.List;

public interface ListingService {

    List<ListingResponse> findAllByListingStatus(ListingStatus top);
}
