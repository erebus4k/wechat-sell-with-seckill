package com.mooc.sell.handler;

import com.mooc.sell.VO.ResultVO;
import com.mooc.sell.config.ProjectUrlConfig;
import com.mooc.sell.exception.SellException;
import com.mooc.sell.exception.SellerAuthorizeException;
import com.mooc.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-19:54
 * @className: com.mooc.sell.handler.SellExceptionHandler
 * @description: TODO
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sellerebus.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://sellerebus.natapp1.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public <T> ResultVO<T> handlerSellerException(SellException e){

        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }



}
