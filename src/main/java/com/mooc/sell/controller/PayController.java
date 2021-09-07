package com.mooc.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.mooc.sell.dto.OrderDTO;
import com.mooc.sell.enums.ResultEnum;
import com.mooc.sell.exception.SellException;
import com.mooc.sell.service.OrderService;
import com.mooc.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-02-14:53
 * @className: com.mooc.sell.controller.PayController
 * @description: TODO
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")  //@PostMapping注解用于处理HTTP POST请求，并将请求映射到具体的处理方法中
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
