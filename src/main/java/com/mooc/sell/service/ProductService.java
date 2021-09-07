package com.mooc.sell.service;

import com.mooc.sell.dataobject.ProductInfo;
import com.mooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-27-18:38
 * @className: com.mooc.sell.service.ProductService
 * @description: TODO
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /**
     * 查询所有在架商品列表
     *
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);    //管理端要查询所有，并且太多了可能需要分页，所以用Pageable

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);


}
