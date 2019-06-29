package com.xy.hx.jdbc;

import java.sql.*;

public class JdbcDemo06 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo",
                    "root", "123456");
            PreparedStatement statement1=connection.prepareStatement("\"select id, name, created_time, modify_time from memo_group \" +\n" +
                    "                         \"where name = ? or id = ?\"");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
