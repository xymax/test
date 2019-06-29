package com.xy.hx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//account 表添加一条数据        insert
public class JdbcDemo02 {

    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        try {
            //1.注册驱动；
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql语句
            String sql = "insert into account values(2,'王五',2000)";
            //3.获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/helloworld", "root", "123456");
            //4.获取执行sql的对象  Statement
            statement = connection.createStatement();
            //5.执行sql语句
            int count = statement.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
             if (statement!=null){
                 try {
                     statement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }

             if (connection!=null){
                 try {
                     connection.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
