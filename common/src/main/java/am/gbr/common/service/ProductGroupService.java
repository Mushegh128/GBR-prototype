package am.gbr.common.service;

import am.gbr.common.entity.ProductGroup;

import java.util.List;

public interface ProductGroupService {

    List<ProductGroup> findAll();

    void save(String title);

    void modifyProductGroup(Long id, String title);

    void delete(Long id);
}
