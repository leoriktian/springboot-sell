package com.tian.sell.utils;

import com.tian.sell.vo.ResultVo;
import lombok.Data;

/**
 * @Author: tyq
 * @Date: 2018/12/4 22:49
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo<Object> resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code , String msg){
        ResultVo<Object> resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }


}
