package com.mooc.sell.enums;

import lombok.Getter;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-29-23:18
 * @className: com.mooc.sell.enums.PayStatusEnum
 * @description: TODO
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0, "等待支付"),SUCCESS(1, "支付成功");
    private final Integer code;
    private final String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
