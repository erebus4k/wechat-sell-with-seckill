package com.mooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mooc.sell.dataobject.OrderDetail;
import com.mooc.sell.enums.OrderStatusEnum;
import com.mooc.sell.enums.PayStatusEnum;
import com.mooc.sell.utils.EnumUtil;
import com.mooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-31-22:41
 * @className: com.mooc.sell.dto.OrderDTO
 * @description: TODO
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
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
    private Integer orderStatus;
    //    支付状态，默认为未支付
    private Integer payStatus;
    //    创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //    更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //这里需要把数据连给对象,给orderservice用
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
