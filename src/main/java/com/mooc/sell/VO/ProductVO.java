package com.mooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 */
@Data
public class ProductVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3956079589165312000L;    //对照API文档结构来写，第二层
    @JsonProperty("name")
    //取名categoryName能让我们后端清晰的知道他代表类名称，但前端API文档写的是name，所以用@JsomProperty可以在序列化的时候告诉前端这是name
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
                                            /*按照API文档，List里边是代表商品的对象，但不能用ProductInfo对象，新建ProductInfoVO
                                                      理由：前端需要几个字段我们这个对象就应该包括几个，出于安全和隐私考虑
                                            比如：ProductInfo里有库存字段，你如果这里用了，你的对手能清晰的看到你的库存，不利于竞争*/

}
