package com.mooc.sell.VO;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * VO是ViewObject。给前端看的  第一层
 * http请求返回的最外层对象
 * @version 1.0

 */
@Data
public class ResultVO<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6404406520191189667L;    //按照API文档去做
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**具体内容*/
    private T data;       //data对象定义为泛型


}
