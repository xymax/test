package com.bittech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Author: secondriver
 * Created: 2019/6/24
 */
public class JdbcCase2 {
    
    public static void main(String[] args) {
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");
            //2. JDBC url协议
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=root";
            String sql = "select id,name,created_time,modify_time from memo_group";
            
            //try-with-resource的方式关闭结果集，命令，连接
            try (
                    Connection connection = DriverManager.getConnection(url);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
            ) {
                //6.
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Timestamp createTime = resultSet.getTimestamp("created_time");
                    Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                    System.out.println(id + " " + name + " " + createTime + " " + modifyTime);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
