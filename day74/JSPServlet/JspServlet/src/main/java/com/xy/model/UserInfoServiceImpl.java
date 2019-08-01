package com.xy.model;

import com.xy.dao.UserInfoDAO;
import com.xy.vo.UserInfo;

public class UserInfoServiceImpl implements IUserInfoService {

    private UserInfoDAO userInfoDAO = new UserInfoDAO();

    public int checkUserInfoService(UserInfo userInfo) {
        return userInfoDAO.checkUserInfo(userInfo);
    }
}
