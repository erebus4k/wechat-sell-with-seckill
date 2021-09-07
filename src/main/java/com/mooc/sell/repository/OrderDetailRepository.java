package com.mooc.sell.repository;

import com.mooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−08-30-0:05
 * @className: com.mooc.sell.repository.OrderDetailRepository
 * @description: TODO
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
//    我们查的时候肯定从master里查拿到订单id，然后在订单详情表通过订单id来查。master表1条记录可能对应detail多条记录，所以返回的应该是个list
    List<OrderDetail> findByOrderId(String orderId);
}
