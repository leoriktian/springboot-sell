package com.tian.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * @Author: tyq
 * @Date: 2018/12/4 13:40
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;


    private String mssage;

    ProductStatusEnum(Integer code, String mssage) {
        this.code = code;
        this.mssage = mssage;
    }
}
