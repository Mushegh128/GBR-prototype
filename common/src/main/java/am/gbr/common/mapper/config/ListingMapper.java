package am.gbr.common.mapper.config;

import am.gbr.common.entity.Listing;
import am.gbr.common.request.ListingRequest;
import am.gbr.common.response.ListingResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListingMapper implements BaseMapper<Listing, ListingRequest, ListingResponse> {

    private final ModelMapper mapper;

    @Override
    public Listing toEntity(ListingRequest listingRequest) {
        return mapper.map(listingRequest, Listing.class);
    }

    @Override
    public ListingResponse toResponse(Listing listing) {
        return mapper.map(listing, ListingResponse.class);
    }
}
