package com.mooc.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-29-23:03
 * @className: com.mooc.sell.enums.OrderStatusEnum
 * @description: TODO
 */

@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单"),FINISHED(1, "完结"),CANCEL(2,"已取消");
    private final Integer code;
    private final String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
