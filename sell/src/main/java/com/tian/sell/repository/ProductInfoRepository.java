package com.tian.sell.repository;

import com.tian.sell.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/4 13:07
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo ,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
