package com.xy.service;

import com.xy.dao.UserDao;
import com.xy.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDao();
    public List<User> queryAllery() {
        return userDao.queryAllUser();
    }
}
