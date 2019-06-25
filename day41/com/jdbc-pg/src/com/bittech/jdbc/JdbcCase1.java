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
public class JdbcCase1 {
 
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");
            //2. JDBC url协议
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=root";
            connection = DriverManager.getConnection(url);
            
            //3.
            statement = connection.createStatement();
            
            //4.
            String sql = "select id,name,created_time,modify_time from memo_group";
            
            //5.
            resultSet = statement.executeQuery(sql);
            
            //6.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp createTime = resultSet.getTimestamp("created_time");
                Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                System.out.println(id + " " + name + " " + createTime + " " + modifyTime);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //8.
            if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    
            }
            //9.
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
