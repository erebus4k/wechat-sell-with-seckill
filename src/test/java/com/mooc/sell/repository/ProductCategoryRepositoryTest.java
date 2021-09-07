package com.mooc.sell.repository;

import com.mooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-26-14:49
 * @className: com.mooc.sell.repository.ProductCategoryRepositoryTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)      /*用于单元测试*/
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).orElse(null); /*必须用这种方法找数字的，后边防止null报错*/
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional //可以保证数据库不会留下测试的数据
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱", 13);
        ProductCategory result = repository.save(productCategory);   /*.save同时也是更新*/
        Assert.assertNotNull(result);
        //Assert判断是否成功，判断是否为空就行。也可以用Assert.assertNotEquals(null, result)，左边不希望的，右边实际的;
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());

    }


}