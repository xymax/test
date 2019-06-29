package com.xy.hx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//account表，修改数据
public class JdbcDemo03 {


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///helloworld", "root", "123456");
            String sql = "update account set name ='张三' where id=1";
            statement = connection.createStatement();
             int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("更新修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
