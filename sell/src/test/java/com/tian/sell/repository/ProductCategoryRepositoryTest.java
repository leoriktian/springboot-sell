package com.tian.sell.repository;

import com.tian.sell.SellApplicationTests;
import com.tian.sell.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: tyq
 * @Date: 2018/12/4 10:44
 */
@Component
@Transactional
public class ProductCategoryRepositoryTest extends SellApplicationTests{

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());

    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
       // Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }
}