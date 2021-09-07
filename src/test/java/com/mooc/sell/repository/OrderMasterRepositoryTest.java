package com.mooc.sell.repository;

import com.mooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-31-9:31
 * @className: com.mooc.sell.repository.OrderMasterRepositoryTest
 * @description: TODO
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;
    private final String OPENID = "110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerAddress("中国小日本路");
        orderMaster.setOrderAmount(new BigDecimal("2.5"));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }


    @Test
    public void findByBuyerOpenid() throws Exception{
        //  已过时，new PageRequest需要第三个参数Sort.sort   PageRequest request = new PageRequest(1,3, );
        PageRequest request = PageRequest.of(1,3);
        Page<OrderMaster> orderMasterList = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, orderMasterList.getTotalElements());
        // total是result里的一个字段/属性，代表总条数，而content则表示，pagerequest.of条件下（如第一页，第一页三条）有多少条
    }
}