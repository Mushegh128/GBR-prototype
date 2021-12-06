package am.gbr.common.service.impl;


import am.gbr.common.entity.Discount;
import am.gbr.common.repository.DiscountRepository;
import am.gbr.common.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;


    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }
}
