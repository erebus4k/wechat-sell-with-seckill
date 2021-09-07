package com.mooc.sell.dataobject;

import com.mooc.sell.enums.OrderStatusEnum;
import com.mooc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @version 1.0   订单主表
 */

@Entity
@Data
public class OrderMaster {
//    订单id
    @Id
    private String orderId;
//    买家名字
    private String buyerName;
//    买家电话
    private String buyerPhone;
//    买家地址
    private String buyerAddress;
//    买家微信openid
    private String buyerOpenid;
//    订单总金额
    private BigDecimal orderAmount;
//    订单状态，默认为新下单
    //private Integer orderStatus = 0;本来是等于0，但最好代码不写0，我们还是用enums枚举器来做
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
//    支付状态，默认为未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
//    创建时间
    private Date createTime;
//    更新时间
    private Date updateTime;
}
