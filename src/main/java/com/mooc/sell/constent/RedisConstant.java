package com.mooc.sell.constent;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-14:55
 * @className: com.mooc.sell.constent.RedisConstant
 * @description: TODO
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";
    ////注意String.format("字符串A%s","字符串B")会生成“字符串A字符串B”，所以RedisConstant.TOKEN_PREFIX定义要加%s
    Integer EXPIRE = 7200; //2小时
}
