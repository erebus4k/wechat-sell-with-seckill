package com.mooc.sell.converter;

import com.mooc.sell.dataobject.OrderMaster;
import com.mooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-01-14:49
 * @className: com.mooc.sell.converter.OrderMaster2OrderDTOConverter
 * @description: TODO
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(OrderMaster2OrderDTOConverter::convert
        ).collect(Collectors.toList());
    }
}
