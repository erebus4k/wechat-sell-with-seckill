package com.mooc.sell.service;

import com.mooc.sell.dto.OrderDTO;


public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
