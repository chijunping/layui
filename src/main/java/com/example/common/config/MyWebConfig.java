package com.example.common.config;

import com.example.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类 用来让拦截器生效
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    //想使用拦截器除了要创建一个拦截器的类之外 还要有一个配置类去注册拦截器
    @Autowired
    @Qualifier(value="loginInterceptor")
    private  LoginInterceptor loginInterceptor;

    //注册拦截器 重写方法addInterceptors
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration
                = registry.addInterceptor(loginInterceptor);
        //拦截请求  拦截所有
        interceptorRegistration.addPathPatterns("/**");
        //放行请求  登录的和静态资源
        interceptorRegistration.excludePathPatterns(
                "/login",  //登录跳转
                "/user/login",   //登录验证
                "/user/logout",  //登出
                "/layui/**",  //静态资源
                "/lib/**",  //静态资源
                "/captcha",   //验证码
                "/api/**",   //初始化和缓存接口
                "/css/**",   //静态资源
                "/js/**",    //静态资源
                "/images/**",  //静态资源图片
                "/register",    //注册页面
                "/user/register",
                "/welcome"


        );


    }
}
