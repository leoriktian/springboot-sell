package com.tian.sell.enums;

import lombok.Getter;


/**
 * @Author: tyq
 * @Date: 2018/12/4 10:35
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
