package com.tian.sell.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tian.sell.domain.OrderDetail;
import com.tian.sell.dto.OrderDTO;
import com.tian.sell.enums.ResultEnum;
import com.tian.sell.exception.SellException;
import com.tian.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tyq
 * @Date: 2018/12/6 9:23
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

      //  BeanUtils.copyProperties(orderForm, orderDTO);  这种转换方式在此处不能用,因为他们之间的属性名定义不同

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList =  gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("[对象转换]错误, string", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
