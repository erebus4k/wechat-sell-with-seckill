package com.mooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**商品详情
 */
@Data
public class ProductInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4373156383253715249L;  //第三层


    @JsonProperty("id")
    private String productID;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
