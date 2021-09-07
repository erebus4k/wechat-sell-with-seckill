package com.mooc.sell.dto;

import lombok.Data;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-01-14:30
 * @className: com.mooc.sell.dto.CartDTO
 * @description: TODO
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}