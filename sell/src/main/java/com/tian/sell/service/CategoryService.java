package com.tian.sell.service;

import com.tian.sell.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/4 12:26
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
