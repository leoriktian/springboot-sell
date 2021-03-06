package com.tian.sell.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @Author: tyq
 * @Date: 2018/12/4 20:50
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
