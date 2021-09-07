package com.mooc.sell.repository;

import com.mooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-10:31
 * @className: com.mooc.sell.repository.SellerInfoRepository
 * @description: TODO
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}