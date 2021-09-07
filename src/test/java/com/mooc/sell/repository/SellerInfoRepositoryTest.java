package com.mooc.sell.repository;

import com.mooc.sell.dataobject.SellerInfo;
import com.mooc.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-10:33
 * @className: com.mooc.sell.repository.SellerInfoRepositoryTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @org.junit.Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = repository.findByOpenid("abc");
        Assert.assertEquals("abc", result.getOpenid());
    }

}