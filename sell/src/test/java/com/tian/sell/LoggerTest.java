package com.tian.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: tyq
 * @Date: 2018/12/3 20:08
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest{

  // private final log log = logFactory.getlog(logTest.class);
   @Test
   public void test1(){

      String name = "tian";
      String password = "123456";
      log.debug("debug...");//默认级别是info,级别大于info能输出来,反之不行
      log.info("info...");    //trace<debug<info<warn<error
      log.info("name: " + name + " password: " + password);//拼接方式输出变量
      log.info("name: {},password: {}",name, password);
      log.warn("warn...");
      log.error("error...");
   }
}
