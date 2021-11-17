package com.example.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //拦截器 判断session中是否有用户信息
        //获取session
        Object userInfo = request.getSession().getAttribute("userInfo");
        if(userInfo ==null){
            //未登录
            //重定向到  controller login
            log.debug("未登录请求:"+request.getRequestURI());
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        //放行
        log.debug("登录请求:"+request.getRequestURI());
        return true;
    }
}
