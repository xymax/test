package com.xy.service;

import com.xy.mapper.UserMapper;
import com.xy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> queryUserService() throws Exception {
        return userMapper.queryUserList();
    }
}
