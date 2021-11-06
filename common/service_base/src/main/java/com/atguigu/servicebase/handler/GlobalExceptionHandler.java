package com.atguigu.servicebase.handler;

import com.atguigu.commontuils.ResultUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常
 */
@Api(value = "全局异常")
@ControllerAdvice //全局异常注解
@Slf4j //日志
public class GlobalExceptionHandler {

    //异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultUtils exception(Exception e){
        e.printStackTrace();
        return ResultUtils.error().message("全局异常处理");
    }

    /**
     * 特殊
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResultUtils exception(ArithmeticException e){
        e.printStackTrace();
        return ResultUtils.error().message("ArithmeticException异常处理");
    }
    /**
     * 自定义
     */
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public ResultUtils exception(GuliException e){
        return ResultUtils.error().code(e.getCode()).message(e.getMessage());
    }
}
