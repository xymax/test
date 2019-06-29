package com.xy.hx.jdbc;

import java.sql.*;

public class JdbcDemo08 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from account";
            connection = DriverManager.getConnection("jdbc:mysql:///helloworld"
                    , "root", "123456");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


//            resultSet.next();
//            int id = resultSet.getInt(1);
//
//            String name = resultSet.getString("name");
//
//            double balance = resultSet.getDouble(3);
//
//            System.out.println(id + "---" + name + "---" + balance);



            while (resultSet.next()){
                //循环判断游标是否是最后一行末尾
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble(3);

                System.out.println(id + "---" + name + "---" + balance);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
