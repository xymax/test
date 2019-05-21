package com.bittech.classloader;

import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestObject {
    
    public static void main(String[] args) {
        Class cls = Object.class;
        System.out.println(cls);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method);
        }
    }
}
