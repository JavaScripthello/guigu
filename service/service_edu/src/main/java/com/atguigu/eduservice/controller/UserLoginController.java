package com.atguigu.eduservice.controller;


import com.atguigu.commontuils.ResultCode;
import com.atguigu.commontuils.ResultUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟用户登录
 */
@CrossOrigin // 解决跨域
@RestController
@RequestMapping("/userService/user")
public class UserLoginController {
    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public ResultUtils login(){
        //返回token
        return  ResultUtils.ok().data("token","admin");
    }

    @RequestMapping("/info")
    public  ResultUtils info(){
        //给前端反三个值，角色 账号 头像
        return  ResultUtils.ok().data("roles","admin").data("name","admin").data("avatar","avatar");
    }
}
