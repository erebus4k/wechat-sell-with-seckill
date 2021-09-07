package com.mooc.sell.service;

import com.mooc.sell.dataobject.SellerInfo;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-10:48
 * @className: com.mooc.sell.service.SellerService
 * @description: TODO
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
