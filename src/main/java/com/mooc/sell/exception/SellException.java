package com.mooc.sell.exception;

import com.mooc.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-31-23:00
 * @className: com.mooc.sell.exception.SellException
 * @description: TODO
 */
@Getter
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
