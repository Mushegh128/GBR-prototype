package am.gbr.common.service.impl;

import am.gbr.common.entity.MadeInCountry;
import am.gbr.common.repository.MadeInCountryRepository;
import am.gbr.common.service.MadeInCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MadeInCountryServiceImpl implements MadeInCountryService {

    private final MadeInCountryRepository madeInCountryRepository;

    @Override
    public List<MadeInCountry> findAll() {
        return madeInCountryRepository.findAll();
    }
}
