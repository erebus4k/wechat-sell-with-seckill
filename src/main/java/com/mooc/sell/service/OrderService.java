package com.mooc.sell.service;

import com.mooc.sell.dataobject.OrderMaster;
import com.mooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-31-22:34
 * @className: com.mooc.sell.service.OrderService
 * @description: TODO
 */
public interface OrderService {
    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /**查询单个订单*/
    OrderDTO findOne(String orderId);
    /**查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
    /** 查询订单列表. */
    Page<OrderDTO> findList(Pageable pageable);
}
