package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {

        return userMapper.getUser(user);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }
}
