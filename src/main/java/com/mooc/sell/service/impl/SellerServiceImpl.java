package com.mooc.sell.service.impl;

import com.mooc.sell.dataobject.SellerInfo;
import com.mooc.sell.repository.SellerInfoRepository;
import com.mooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
