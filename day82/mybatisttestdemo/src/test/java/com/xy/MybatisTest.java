package com.xy;

import com.xy.bz.UserBz;
import com.xy.mapper.UserMapper;
import com.xy.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void testinit(){
        String file = "sqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testQueryUserByZH(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserZH(null);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testQueryUserCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int flag = userMapper.queryUserCount(null);
            System.out.println(flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void testQueryUserByMoreIds(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(24);
            ids.add(25);
            ids.add(26);
            UserBz userBz = new UserBz();
            userBz.setMoreIds(ids);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserByMoreIds(userBz);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
