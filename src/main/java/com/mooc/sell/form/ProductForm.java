package com.mooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-04-0:29
 * @className: com.mooc.sell.form.ProductForm
 * @description: TODO
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
