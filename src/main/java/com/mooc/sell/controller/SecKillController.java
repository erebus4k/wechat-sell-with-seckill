package com.mooc.sell.controller;

import com.mooc.sell.service.impl.SecKillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 synchronized处理单机的并发
 * 后面用看redis分布式锁基本使用
 */
@RestController
public class SecKillController {

    @Autowired
    private SecKillServiceImpl secKillService;


    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId)throws Exception
    {
        return secKillService.querySecKillProductInfo(productId);
    }




}
