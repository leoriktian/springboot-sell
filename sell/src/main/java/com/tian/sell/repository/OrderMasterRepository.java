package com.tian.sell.repository;

import com.tian.sell.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: tyq
 * @Date: 2018/12/5 9:30
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid( String buyerOpenid, Pageable pageable);

}
