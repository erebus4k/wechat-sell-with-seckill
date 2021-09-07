package com.mooc.sell.repository;

import com.mooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-31-9:30
 * @className: com.mooc.sell.repository.OrderDetailRepositoryTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductPrice(new BigDecimal("2.2"));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111111");
        Assert.assertNotEquals(0, orderDetailList.size());



    }
}