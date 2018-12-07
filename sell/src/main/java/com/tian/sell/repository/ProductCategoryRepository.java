package com.tian.sell.repository;

import com.tian.sell.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/4 10:41
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory ,Integer>{

   List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);


}
