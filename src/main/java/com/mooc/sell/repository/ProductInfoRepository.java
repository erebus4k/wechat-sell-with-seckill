package com.mooc.sell.repository;

import com.mooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-27-16:40
 * @className: com.mooc.sell.repository.ProductInfoRepository
 * @description: TODO
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    //功能一：查询上架的商品，通过商品状态来查
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
