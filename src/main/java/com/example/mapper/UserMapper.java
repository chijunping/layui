package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;

/**
* @Entity generator.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    public User getUser(User user);

     int register(User user);
}
