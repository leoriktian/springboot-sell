package com.tian.sell.repository;

import com.tian.sell.SellApplicationTests;
import com.tian.sell.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: tyq
 * @Date: 2018/12/5 10:22
 */
@Component
public class OrderDedailRepositoryTest extends SellApplicationTests{

  @Autowired
  private OrderDedailRepository orderDedailRepository;


    @Test
    public void saveTest(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123678");
        orderDetail.setOrderId("18345688");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("1196366160022");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDedailRepository.save(orderDetail);
       // Assert.assertNotEquals(null,result);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = orderDedailRepository.findByOrderId("18345688");
        Assert.assertNotEquals(0, orderDetailList.size());

    }
}