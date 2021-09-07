package com.mooc.sell.repository;

import com.mooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: TODO
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
//    功能：查某个人的订单，而且得分页，防止订单过多
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
