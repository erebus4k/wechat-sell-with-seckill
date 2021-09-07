package com.mooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-25-17:36
 * @className: com.mooc.sell.LoggerTest
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j    //需要lombok依赖，用来简化代码的，在pom.xml里加依赖
public class LoggerTest {
    // private final Logger logger = LoggerFactory.getLogger(LoggerTest这里的类每次都要跟上边一样太麻烦.class);
    // 所以改用@Slf4j注解
    @Test
    public void test1(){
        String name = "imooc";
        String password = "123456";
        log.debug("debug...");
        // log.info("name: " + name + " ,password: " + password);  这样写需要自己加逗号
        log.info("name: {}, password: {}", name, password);   // 所以推荐这样写
        log.error("error...");
    }

}
