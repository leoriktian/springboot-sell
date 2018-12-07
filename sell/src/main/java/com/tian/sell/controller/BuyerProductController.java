package com.tian.sell.controller;

import com.tian.sell.domain.ProductCategory;
import com.tian.sell.domain.ProductInfo;
import com.tian.sell.service.CategoryService;
import com.tian.sell.service.ProductService;
import com.tian.sell.utils.ResultVoUtil;
import com.tian.sell.vo.ProductInfoVo;
import com.tian.sell.vo.ProductVo;
import com.tian.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卖家商品
 *
 * @Author: tyq
 * @Date: 2018/12/4 20:47
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResultVo list() {

        //1,查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();


        //2, 查询类目(一次性查询)
      //  List<Integer> categoryTypeList  = new ArrayList<>();
       // for(ProductInfo productInfo : productInfoList){
       //传统方法
       // for(ProductInfo productInfo : productInfoList){
       //    categoryTypeList.add(productInfo.getCategoryType());
     //  }
       //精简方法( java8 , lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3,拼接数据
        List<ProductVo> productVoList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
               if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                ProductInfoVo productInfoVo = new ProductInfoVo();
                BeanUtils.copyProperties(productInfo,productInfoVo);
                productInfoVoList.add(productInfoVo);
               }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVoUtil.success(productVoList);
    }
}
