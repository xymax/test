package com.xy.hx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //jdbc使用统一的一套java代码可以操作所有关系型数据库。
        //JDBC:定义了一套操作所有关系型数据库规则（接口）数据库厂商设计类去
        //     实现这个接口，驱动包就是实现类。
        /*
         * 操作步骤：1.导入jar包
         *         2.注册驱动
         *
         *         3.获取数据库连接对象Connection
         *         4.定义sql
         *         5.获取执行sql的语句 Statement
         *         6.执行sql，接收返回结果
         *         7.处理结果
         *         8.释放资源
         * */
        //1.导入java包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象       语法：url:"jdbc:mysql://ip地址(域名):端口号/数据库名称","账号"，“"密码"。

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shops",
                "root", "123456");
        //可以简写
       // Connection con= DriverManager.getConnection("jdbc:mysql:///helloworld","root","123456");
        //4.定义sql语句
        String sql = "update account set balance =500 where id = 1";
        //5.获取执行sql的对象，Statement
        Statement statement = con.createStatement();
        //6.执行sql语句
        int count = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        con.close();


    }
}
