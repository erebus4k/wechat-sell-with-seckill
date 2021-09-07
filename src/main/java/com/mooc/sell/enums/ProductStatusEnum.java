package com.mooc.sell.enums;

import lombok.Getter;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-28-12:45
 * @className: com.mooc.sell.enums.ProductStatusEnum
 * @description: TODO
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "在架"),DOWN(1, "下架");
    private final Integer code;
    private final String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
