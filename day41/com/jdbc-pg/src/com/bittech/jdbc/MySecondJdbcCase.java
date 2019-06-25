package com.bittech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: secondriver
 * Created: 2019/6/24
 */
public class MySecondJdbcCase {
    
    /*
        1. 加载数据库的JDBC驱动（JDBC API）
        2. 创建连接
        3. 创建命令
        4. 准备SQL语句
        5. 执行SQL
        6. 处理结果
        7. 关闭结果
        8. 关闭命令
        9. 关闭连接
     */
    public static void main(String[] args) {
        
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");
            //2. JDBC url协议
            
            //jdbc:<databaseType>://<host>:<port>/<databaseName>?user=<your user name>&password=<your password>
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=root
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=root";
            Connection connection = DriverManager.getConnection(url);
            
            //3.
            Statement statement = connection.createStatement();
            
            //4.
            String sql = "insert into memo_group (name,created_time) values ('今天是个好日子','2019-06-24 19:42:00');";
            
            //5.
            int effect = statement.executeUpdate(sql);
            
            //6.
            System.out.println(effect);
            
            //7.
            //resultSet.close();
            
            //8.
            statement.close();
            //9.
            connection.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
