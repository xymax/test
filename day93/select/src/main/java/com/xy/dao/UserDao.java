package com.xy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jws.Oneway;

import com.xy.tools.DBmerager;
import com.xy.vo.User;

public class UserDao {
    private DBmerager dBmerager;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public List<User> queryAllUser() {
        String sql = "select * from t_user";

        try {
            dBmerager = new DBmerager();
            connection = dBmerager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<User> userList = new ArrayList<User>();

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                userList.add(user);

            }
            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
