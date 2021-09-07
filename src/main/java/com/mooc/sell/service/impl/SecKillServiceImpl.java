package com.mooc.sell.service.impl;

import com.mooc.sell.exception.SellException;
import com.mooc.sell.service.RedisLock;
import com.mooc.sell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-05-14:46
 * @className: com.mooc.sell.service.impl.SecKillServiceImpl
 * @description: TODO
 */
@Service
public class SecKillServiceImpl {

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10 * 1000; //超时时间 10s

    /**
     * 国庆活动，皮蛋粥特价，限量100000份
     */
    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;

    //初始化
    static
    {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String queryMap(String productId)  {
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                +" 还剩：" + stock.get(productId)+" 份"
                +" 该商品成功下单用户数目："
                +  orders.size() +" 人" ;
    }

    public String querySecKillProductInfo(String productId)  {
        return this.queryMap(productId);
    }

    /**
     * 下单操作，无非就是在这个方法前后用redis加锁 解锁撒，所以这里先写一个redis加锁解锁的方法，见RedisLock类
     * @param productId 哪个商品
     * @return 库存
     */
    public void orderProductMockDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new  SellException(101,"哎哟喂，人也太多了，换个姿势再试试~~");
        }
        //1.查询该商品库存，为0则活动结束。
        int stockNum = stock.get(productId);
        if(stockNum == 0) {
            throw new SellException(100,"活动结束");
        }else {
            //2.下单(模拟不同用户openid不同)
            orders.put(KeyUtil.genUniqueKey(),productId);
            //3.减库存
            stockNum =stockNum-1;
            try {
                //真实场景里减库存还有IO操作等其他很多操作，这里用sleep模拟一下。
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }
        //解锁
        redisLock.unlock(productId,String.valueOf(time));
    }
}
