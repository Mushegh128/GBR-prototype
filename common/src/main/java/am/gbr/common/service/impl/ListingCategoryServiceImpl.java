package am.gbr.common.service.impl;

import am.gbr.common.entity.ListingCategory;
import am.gbr.common.repository.ListingCategoryRepository;
import am.gbr.common.service.ListingCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingCategoryServiceImpl implements ListingCategoryService {

    private final ListingCategoryRepository listingCategoryRepository;

    @Override
    public List<ListingCategory> findAll() {
        return listingCategoryRepository.findAll();
    }
}
