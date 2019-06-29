package com.xy.hx.util;

/*
 * jdbc工具类
 *
 *
 *
 * */
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

     //为什么是静态变量的？
     //因为只有静态变量才能被静态代码块和静态方法所访问。

    /*
     * 文件的读取只需要读取一次就可以拿到这些值。使用静态代码块。
     *
     * */
    static {
        //读取资源文件，获取值。
        try {
            //1.创建Properties集合类
            Properties properties = new Properties();

            //获取src路径下的文件的方式----->ClassLoader类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println(path);

            //2.加载文件(1.使用绝对路径，不可以使用相对路径)

            //  properties.load(new FileReader("F:\\QQ接收文件\\201906\\day28\\src\\jdbc.properties"));

            //（2.使用Classloader类加载器）
            properties.load(new FileReader(path));


            //3.获取数据，赋值。
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver= properties.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*
     * 获取连接，返回连接对象。
     *
     * */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /*
     * 释放资源
     *
     * */
    public static void close(Statement statement, Connection connection) {
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

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
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
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
