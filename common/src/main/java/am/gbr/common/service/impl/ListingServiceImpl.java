package am.gbr.common.service.impl;

import am.gbr.common.entity.Listing;
import am.gbr.common.entity.ListingStatus;
import am.gbr.common.mapper.config.ListingMapper;
import am.gbr.common.repository.ListingRepository;
import am.gbr.common.response.ListingResponse;
import am.gbr.common.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final ListingMapper mapper;

    @Override
    public List<ListingResponse> findAllByListingStatus(ListingStatus status) {
        List<Listing> listings = listingRepository.findAllByListingStatus(status);
        return listings.stream().map(mapper::toResponse).collect(Collectors.toList());
    }
}
