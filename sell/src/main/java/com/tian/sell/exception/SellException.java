package com.tian.sell.exception;

import com.tian.sell.enums.ResultEnum;

/**
 * @Author: tyq
 * @Date: 2018/12/5 12:04
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
