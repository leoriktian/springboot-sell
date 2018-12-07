package com.tian.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 *
 * @Author: tyq
 * @Date: 2018/12/4 21:11
 */
@Data
public class ProductVo {

    /**
     * 类目名
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;


}
