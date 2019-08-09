package com.xy.mapper;

import com.xy.bz.UserBz;
import com.xy.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<UserEx> queryUserZH(UserBz userBz) throws Exception;
    public int queryUserCount(UserBz userBz) throws Exception;
    public List<UserEx> queryUserByMoreIds(UserBz userBz) throws Exception;
}
