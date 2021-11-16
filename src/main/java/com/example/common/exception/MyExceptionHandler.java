package com.example.common.exception;

import com.example.common.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice   //增强controller
public class MyExceptionHandler {
//    全局异常处理
//    全局数据绑定
//    全局数据预处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> myhandler(Exception e){


        return Result.fail("系统错误"+e.getMessage());

    }

}
