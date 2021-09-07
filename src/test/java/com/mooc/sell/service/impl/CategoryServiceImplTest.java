package com.mooc.sell.service.impl;

import com.mooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-26-20:41
 * @className: com.mooc.sell.service.impl.CategoryServiceImplTest
 * @description: TODO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @org.junit.Test                   /*注意，Test别导错包了！！！，不是jupiter的，不然会报错
                                      org.junit.runners.model.InvalidTestClassError: Invalid test class*/
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(9);
        Assert.assertEquals(new Integer(9), productCategory.getCategoryId());
    }

    @org.junit.Test
    public void findAll() throws Exception{
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @org.junit.Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception{
        ProductCategory productCategory = new ProductCategory("男生最爱",11);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}