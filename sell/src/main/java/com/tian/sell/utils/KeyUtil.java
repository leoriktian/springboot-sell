package com.tian.sell.utils;

import java.util.Random;

/**
 * @Author: tyq
 * @Date: 2018/12/5 12:43
 */
public class KeyUtil {

    /**
     * 生成唯一的主键key
     * 格式: 当前时间 + 随机数
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

