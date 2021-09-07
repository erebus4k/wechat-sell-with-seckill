package com.mooc.sell.service.impl;

import com.mooc.sell.dataobject.ProductInfo;
import com.mooc.sell.enums.ProductStatusEnum;
import com.mooc.sell.repository.ProductInfoRepository;
import com.mooc.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-28-13:52
 * @className: com.mooc.sell.service.impl.ProductServiceImplTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @org.junit.Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @org.junit.Test
    public void findUpAll() throws Exception{
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @org.junit.Test
    public void findAll() throws Exception{
        PageRequest request = PageRequest.of(0,2);  //视频的new PageRequest(0,2)已经过时没法用了。用PageRequest.of代替
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        //为什么（）里不是pageable，因为PageRequest继承AbstractPageRequest抽象类，这个抽象类实现了pageable，pageable只是接口

        //System.out.println(productInfoPage.getTotalElements());   //这里的测试是把分页的元素都打出来了
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @org.junit.Test
    public void save() throws Exception{
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal("3.2"));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void onSale() {
        ProductInfo result = productService.onSale("123456");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale() {
        ProductInfo result = productService.offSale("123456");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }



}