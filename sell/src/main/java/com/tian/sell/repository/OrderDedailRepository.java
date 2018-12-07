package com.tian.sell.repository;

import com.tian.sell.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/5 9:34
 */
public interface OrderDedailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
