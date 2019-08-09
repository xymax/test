package com.xy.bz;

import com.xy.po.UserEx;

import java.util.List;

public class UserBz {

    private List<Integer> moreIds;

    private UserEx userEx;

    public UserEx getUserEx() {
        return userEx;
    }

    public void setUserEx(UserEx userEx) {
        this.userEx = userEx;
    }

    public List<Integer> getMoreIds() {
        return moreIds;
    }

    public void setMoreIds(List<Integer> moreIds) {
        this.moreIds = moreIds;
    }



}
