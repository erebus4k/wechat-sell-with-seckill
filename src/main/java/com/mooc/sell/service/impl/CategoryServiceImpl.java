package com.mooc.sell.service.impl;

import com.mooc.sell.dataobject.DAO.ProductCategoryDao;
import com.mooc.sell.dataobject.ProductCategory;
import com.mooc.sell.repository.ProductCategoryRepository;
import com.mooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// 使service接口的方法实现
/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-26-20:27
 * @className: com.mooc.sell.service.impl.CategoryServiceImpl
 * @description: TODO
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;                    //引入DAO

//    @Autowired
//    private ProductCategoryDao productCategoryDao;      // mybatis

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
