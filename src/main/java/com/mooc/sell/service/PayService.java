package com.mooc.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.mooc.sell.dto.OrderDTO;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-02-15:00
 * @className: com.mooc.sell.service.PayService
 * @description: TODO
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}

