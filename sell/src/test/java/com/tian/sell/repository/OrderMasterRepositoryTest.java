package com.tian.sell.repository;

import com.tian.sell.SellApplicationTests;
import com.tian.sell.domain.OrderMaster;
import com.tian.sell.enums.OrderStatusEnum;
import com.tian.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: tyq
 * @Date: 2018/12/5 9:38
 */
@Component
public class OrderMasterRepositoryTest extends SellApplicationTests{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private final String OPENID = "1101110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("13579");
        orderMaster.setBuyerName("二师兄");
        orderMaster.setBuyerPhone("16688812412");
        orderMaster.setBuyerAddress("研发二部");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(3.6));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest pageRequest = new PageRequest(1, 3);
        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}