package com.tian.sell.service.impl;

import com.tian.sell.SellApplicationTests;
import com.tian.sell.domain.OrderDetail;
import com.tian.sell.dto.CartDTO;
import com.tian.sell.dto.OrderDTO;
import com.tian.sell.enums.OrderStatusEnum;
import com.tian.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: tyq
 * @Date: 2018/12/5 13:49
 */
@Component
@Slf4j
public class OrderServiceImplTest extends SellApplicationTests{

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "1544004690955720924";


    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("大师兄");
        orderDTO.setBuyerAddress("五行山");
        orderDTO.setBuyerPhone("18888866666");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail ol = new OrderDetail();
        ol.setProductId("13579");
        ol.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("2468");
        o2.setProductQuantity(2);

        orderDetailList.add(ol);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result = {}" ,result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());

    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}