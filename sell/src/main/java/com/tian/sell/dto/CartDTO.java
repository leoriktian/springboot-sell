package com.tian.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @Author: tyq
 * @Date: 2018/12/5 13:10
 */
@Data
public class CartDTO {

    /** 商品id. */
    private String productId;

    /** 商品数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
