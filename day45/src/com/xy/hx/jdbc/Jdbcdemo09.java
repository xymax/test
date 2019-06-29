package com.xy.hx.jdbc;

import com.xy.hx.Emp.Emp;
import com.xy.hx.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习：
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 * 1. 定义Emp类
 * 2. 定义方法 public List<Emp> findAll(){}
 * 3. 实现方法 select * from emp;
 */
public class Jdbcdemo09 {
    /*
     * 查询所以emp对象
     * */
    public static void main(String[] args) {
        List<Emp> list = new Jdbcdemo09().findAll2();
        System.out.println(list);
    }


    public List<Emp> findAll() {
        ResultSet resultSet=null;
        Statement statement=null;
        Connection connection=null;
        List<Emp> list=null;

        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            2.获取数据库连接；
            connection = DriverManager.getConnection("jdbc:mysql:///helloworld"
                    , "root", "123456");
//            3.定义sql
            String sql = "select * from emp";
//            4.获取执行啊sql的对象
            statement = connection.createStatement();
//            5.执行sql
            resultSet = statement.executeQuery(sql);
            //遍历结果集，封装对象，装载集合。

            Emp emp = null;
            //创建一个list集合
            list=new ArrayList<Emp>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date join_date = resultSet.getDate("join_date");
                int dept_id = resultSet.getInt("dept_id");
             //创建emp对象，并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
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

        return list;
    }










    /*
     * 演示jdbc工具类
     * */



    public List<Emp> findAll2() {
        ResultSet resultSet=null;
        Statement statement=null;
        Connection connection=null;
        List<Emp> list=null;

        //1.注册驱动
        try {


//            Class.forName("com.mysql.jdbc.Driver");
////            2.获取数据库连接；
//            connection = DriverManager.getConnection("jdbc:mysql:///helloworld"
//                    , "root", "123456");


            JdbcUtils.getConnection();



//            3.定义sql
            String sql = "select * from emp";
//            4.获取执行啊sql的对象
            statement = connection.createStatement();
//            5.执行sql
            resultSet = statement.executeQuery(sql);
            //遍历结果集，封装对象，装载集合。

            Emp emp = null;
            //创建一个list集合
            list=new ArrayList<Emp>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date join_date = resultSet.getDate("join_date");
                int dept_id = resultSet.getInt("dept_id");
                //创建emp对象，并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,connection);

        }

        return list;
    }

}
