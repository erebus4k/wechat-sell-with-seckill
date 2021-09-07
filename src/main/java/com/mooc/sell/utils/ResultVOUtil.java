package com.mooc.sell.utils;

import com.mooc.sell.VO.ProductVO;
import com.mooc.sell.VO.ResultVO;

import java.util.List;

/**
 * @version 1.0
 */
public class ResultVOUtil {         //正常情况
    public static <T> ResultVO<T> success(T object){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return  resultVO;
    }

    public static <T> ResultVO<T> success(){   //什么都不传
        return success(null);
    }

    public static <T> ResultVO<T> error(Integer code, String msg){ //发生错误
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
