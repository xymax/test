package com.xy.po;

public class User {
    //   the character of the persistence objects is must be identified
    private int userId;

    private String userName;

    private String userAddr;

    // default constructor is established here
    public User(){

    }

    //getter/setter

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }
}
