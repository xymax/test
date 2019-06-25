package com.bittech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: secondriver
 * Created: 2019/6/24
 */
public class JdbcTemplate2 {
    
    /*
       不变的：
       1. 加载驱动
       2. 获取连接
       3. 创建命令
       4. 关闭（结果，命令，连接）
       
       变的
       1. SQL
       2. 执行命令
       3. 处理结果
       a. select
       b. insert update delete
    
     */
    public <P,R> R execute(String sql, Handler<P,R> handler) {
        this.loadDriver();
        this.createConnection();
        this.createStatement();
        //执行 SQL
        //假设：CRUD
        Object t;
        if (sql.trim().toUpperCase().startsWith("SELECT")) {
            this.resultSet = this.executeQuery(sql);
            //处理结果
            t = handler.handler((P) this.resultSet);
        } else {
            Integer effect = this.executeUpdate(sql);
            //处理结果
            t = handler.handler((P) effect);
        }
        this.close();
        return (R) t;
    }
    
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    //加载驱动
    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    //创建连接
    private void createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            this.connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //创建命令
    private void createStatement() {
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private int executeUpdate(String sql) {
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    private ResultSet executeQuery(String sql) {
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //关闭资源
    private void close() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    @FunctionalInterface
    interface Handler<P, R> {
        R handler(P p);
    }
    
}
