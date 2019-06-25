package com.bittech.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Author: secondriver
 * Created: 2019/6/24
 */
public class TestJdbcTemplate2 {
    
    public static void main(String[] args) {
        
        JdbcTemplate2 jdbcTemplate2 = new JdbcTemplate2();
        
//        String rs = jdbcTemplate2.execute("select id,name,created_time, modify_time from memo_group",
//                new JdbcTemplate2.Handler<ResultSet, String>() {
//            @Override
//            public String handler(ResultSet resultSet) {
//                StringBuilder sb = new StringBuilder();
//                try {
//                    while (resultSet.next()) {
//                        int id = resultSet.getInt("id");
//                        String name = resultSet.getString("name");
//                        Timestamp createTime = resultSet.getTimestamp("created_time");
//                        Timestamp modifyTime = resultSet.getTimestamp("modify_time");
//                        sb.append(id + " " + name + " " + createTime + " " + modifyTime);
//                        sb.append("\n");
//                    }
//                } catch (SQLException e) {
//
//                }
//                return sb.toString();
//            }
//        });
    
    
        String rs = jdbcTemplate2.execute("select id,name,created_time, modify_time from memo_group",
                (JdbcTemplate2.Handler<ResultSet, String>) resultSet -> {
                    StringBuilder sb = new StringBuilder();
                    try {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            Timestamp createTime = resultSet.getTimestamp("created_time");
                            Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                            sb.append(id + " " + name + " " + createTime + " " + modifyTime);
                            sb.append("\n");
                        }
                    } catch (SQLException e) {
    
                    }
                    return sb.toString();
                });
        
        System.out.println(rs);
        
        
//        String effect=jdbcTemplate2.execute("delete from memo_group", (JdbcTemplate2.Handler<Integer, String>) integer -> "删除了"+integer+"条数据");
    
        String effect=jdbcTemplate2.execute("delete from memo_group", (p)->"删除了"+p+"条数据");
        System.out.println(effect);
    }
    
}
