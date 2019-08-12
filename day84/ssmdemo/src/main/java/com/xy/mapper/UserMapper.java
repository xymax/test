package com.xy.mapper;

import com.xy.po.User;

import java.util.List;

public interface UserMapper {
    public List<User> queryUserList() throws Exception;

}
