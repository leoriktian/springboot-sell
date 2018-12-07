package com.tian.sell.service;

import com.tian.sell.dto.OrderDTO;

/**
 * 买家
 * @Author: tyq
 * @Date: 2018/12/6 12:39
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancel(String openid, String orderId);
}
