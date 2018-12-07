package com.tian.sell.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: tyq
 * @Date: 2018/12/6 17:09
 */
@Component
public class WechatMpController {

    @Bean
    public WxMpService wxMpService(){
//
//        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
//        wxMpService.setWxMpConfigStorage();
        return null;
    }



}
