package am.gbr.common.service.impl;

import am.gbr.common.entity.ListingGroup;
import am.gbr.common.repository.ListingGroupRepository;
import am.gbr.common.service.ListingGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingGroupServiceImpl implements ListingGroupService {

    private final ListingGroupRepository listingGroupRepository;

    @Override
    public List<ListingGroup> findAll() {
        return listingGroupRepository.findAll();
    }
}
