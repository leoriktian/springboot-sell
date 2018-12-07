package com.tian.sell.service;

import com.tian.sell.domain.ProductInfo;
import com.tian.sell.dto.CartDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/4 13:24
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

  //  Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
