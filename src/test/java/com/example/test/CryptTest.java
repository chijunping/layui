package com.example.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.vo.Result;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;


public class CryptTest {

    @Test
    public void test(){
        //md5 加密 spring提供,加盐自己处理  直接这样写不行 会被破解 所以要加盐(随机字符串) 这样数据库中需要加上一个盐的字段
//        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
//        System.out.println(s);

        //spring安全框架提供的加密方法,可以自动加盐,无需自己保存盐值 这种方法产生的密码都是随机的需要专门工具验证
        BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        String encode1 = passwordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(encode1);

        //验证  提供原密码和加密后的密码 true为相同
        boolean matches = passwordEncoder.matches("123456", "$2a$10$Rk7OFBuNQgRAdiPKGfIjBOh1VG34jdW5gR.VKIREuEfGieRdQlXDa");
        System.out.println(matches);

    }


}
