package com.xy.tools;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBmerager {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    private static String driver;
    private static String url;
    private static String username;
    private static String password;


/*    public String driver = "com.mysql.jdbc.Driver";
    public String username = "root";
    public String password = "123456";
    public String url = "jdbc:mysql:localhost://3306/tt";*/

static {

    try {
        ClassLoader classLoader=DBmerager.class.getClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
         driver = properties.getProperty("driver");
         url = properties.getProperty("url");
         username = properties.getProperty("username");
         password = properties.getProperty("password");
    } catch (IOException e) {
        e.printStackTrace();
    }


}



    public Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet executeQuery(String sql) {
        try {
            connection = this.connection;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public int update(String sql){
        int flag=0;
        try {
            connection=this.getConnection();
            statement=connection.createStatement();
            flag = statement.executeUpdate(sql);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean execute(String sql){
        try {
            connection=this.getConnection();
            statement=connection.createStatement();
            return statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void closeDB() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}
