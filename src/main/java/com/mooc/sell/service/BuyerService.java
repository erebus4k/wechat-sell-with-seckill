package com.mooc.sell.service;

import com.mooc.sell.dto.OrderDTO;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-01-20:56
 * @className: com.mooc.sell.service.BuyerService
 * @description: TODO
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
