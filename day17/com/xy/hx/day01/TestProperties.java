package com.xy.hx.day01;

import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        Properties properties=new Properties();
        properties.setProperty("java","java is best");
        properties.setProperty("c++","c++ is best too");
        System.out.println(properties.getProperty("java"));
        System.out.println(properties.getProperty("c++"));

    }
}
