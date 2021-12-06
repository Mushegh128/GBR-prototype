package am.gbr.common.service;

import am.gbr.common.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAll();

    void addProductCategory(ProductCategory productCategory);

    void modifyProductCategory(Long id, String title, String group);

    void delete(Long id);

}
