package com.mooc.sell.service;

import com.mooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-26-20:17
 * @className: com.mooc.sell.service.CategoryService
 * @description: TODO
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);  // 查询一条记录（卖家后台管理）
    List<ProductCategory> findAll();    //查询所有记录（卖家后台管理）
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList); //买家用类别来查询
    ProductCategory save(ProductCategory productCategory);
}

