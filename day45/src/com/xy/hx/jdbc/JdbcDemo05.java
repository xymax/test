package com.xy.hx.jdbc;

import java.sql.*;

public class JdbcDemo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///helloworld", "root", "123456");
            //3.sql语句
            String sql = "select * from account";
            //4.获取执行sql对象
            statement = connection.createStatement();
            //5.执行sql语句
            resultSet = statement.executeQuery(sql);
            //6.1处理结果(让游标向下移动一行)但是有问题，当到最后一行就会报错，因此要判断
            //resultset的返回值是boolean类型，，所以做一个简单判断。
            resultSet.next();
            //6.2获取数据
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            double balance = resultSet.getDouble(3);

            System.out.println(id + "---" + name + "---" + balance);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
