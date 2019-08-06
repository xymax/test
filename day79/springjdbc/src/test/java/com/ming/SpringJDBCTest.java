package com.ming;


import com.ming.vo.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.invoke.empty.Empty;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class SpringJDBCTest {

    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;

    @Before
    public void testInit(){

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) context.getBean("myDataSource");
        System.out.println("dataSource" + dataSource);
    }

    @Test
    public void testUpdateForSpringJDBC(){
        int flag = 0;
        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "update employee set employeeName=? where employeeId=?";
            flag = jdbcTemplate.update(strSql,"WWW",2);
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testInsertForSpringJDBC(){

        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "insert into employee (employeeName,departNum) values (?,?)";
            List<Object[]> listObjects = new ArrayList<Object[]>();
            listObjects.add(new Object[]{"arvin",1});
            listObjects.add(new Object[]{"xiaoming",1});
            listObjects.add(new Object[]{"xiaohua",2});
            jdbcTemplate.batchUpdate(strSql,listObjects);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryForSpringJDBC(){
        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "select * from employee where employeeId=?";
            RowMapper rowMapper = new BeanPropertyRowMapper(Employee.class);
            Employee employee = (Employee) jdbcTemplate.queryForObject(strSql,rowMapper,2);
            System.out.println(employee);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }








}
