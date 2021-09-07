package com.mooc.sell.dataobject.mapper;

import com.mooc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-05-10:40
 * @className: com.mooc.sell.dataobject.mapper.ProductCategoryMapperTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;


    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName","我最讨厌");
        map.put("categoryType", 101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我最讨厌");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> result = mapper.findByCategoryName("我最讨厌");
        Assert.assertNotNull(result);
    }

    @Test
    public void updateByCategoryType(){
        int result = mapper.updateByCategoryType("我最讨厌更新啦", 102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我最讨厌");
        productCategory.setCategoryType(102);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = mapper.deleteByCategoryType(102);
        Assert.assertEquals(1, result);
    }

}