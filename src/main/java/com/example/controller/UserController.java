package com.example.controller;

import com.example.common.vo.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    @ResponseBody
    public Result login(User user, HttpSession session, @RequestParam("captcha") String captcha ,HttpServletRequest request){
        //根据用户名查出的user1   user是用户输入的账户和密码 首先判断是否查询出user1 !=null
        User user1 = userService.login(user);
        //验证码验证
        if(!CaptchaUtil.ver(captcha, request)){
            CaptchaUtil.clear(request);
            return Result.fail("验证码错误!");
        }


        if(user1 !=null){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            //参数1是请求传来的密码,参数2是数据库加密的值 并判断是否相同 返回true或false
            boolean matches = passwordEncoder.matches(user.getPassword(), user1.getPassword());
            //如果相同登录成功
            if(matches){
                //登录成功
                user1.setPassword(null);  //存到session中的密码清空
                session.setAttribute("userInfo", user1); //把用户的账户和用户名信息存到session中
                return Result.success("登录成功"); //返回成功信息给login.html
            }
        }
        //登录失败
        return Result.fail("用户名或密码错误！");
    }


    //注册
    @PostMapping("/register")
    @ResponseBody
    public Result register(User user){
        //先判断数据库中是否有相同的用户名的信息 如果有则禁止注册账户信息 如果没有再注册
        //user 是前台传来的 user1是从数据库中通过user查出来的
        User user1 = userService.login(user);
        if(user1!=null){
            return Result.fail("此账户已存在！");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //new 加密工具
        String encode = passwordEncoder.encode(user.getPassword());  //加密前台传来的密码
        user.setPassword(encode);  //设置加密后的密码
        userService.register(user); //执行注册
        return Result.success("注册成功 请登录");
    }





}
