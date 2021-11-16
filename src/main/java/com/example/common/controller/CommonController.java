package com.example.common.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mapper.DeptMapper;
import com.example.pojo.Emp;
import com.example.pojo.User;
import com.example.service.DeptService;
import com.example.service.EmpService;
import com.example.service.UserService;
import com.sun.glass.ui.View;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CommonController {
    @Autowired
    DeptService deptService;
    @Autowired
    UserService userService;
    @Autowired
    EmpService empService;

    @GetMapping ("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/welcome1")
    public String welcome1(){
        return "welcome1";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response)throws Exception{
        CaptchaUtil.out(request, response);
    }


}

