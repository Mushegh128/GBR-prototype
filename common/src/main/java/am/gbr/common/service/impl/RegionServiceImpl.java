package am.gbr.common.service.impl;

import am.gbr.common.entity.Region;
import am.gbr.common.repository.RegionRepository;
import am.gbr.common.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
}
