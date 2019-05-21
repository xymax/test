package com.bittech.reflect;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestReflect {
    
    public static void threadGetClass() {
        //Date
        //java.util.Date   API
        Date date = new Date();//创建对象
        //类型
        //class 关键字
        //Class 类型
        //Class toString()
        Class aClass = date.getClass();
        System.out.println(aClass);//java.util.Date
        //Class
        
        //如果date是Date类 返回 true  否则 false
        System.out.println(date instanceof Date);
        Class classz = Date.class; //Date类的Class对象
        System.out.println(classz);
        
        //Class.forName
//        java.util.Date => "java.util.Date"
        //className  => 类的全限定名   packageName.className
        
        try {
            Class classzz = Class.forName("java.util.Date");
            System.out.println(classzz);
            
            
            System.out.println("----------");
            //3种方式
            
            // 当前三个Class对象 都是描述 java.util.Date
            System.out.println(aClass == classz);
            System.out.println(classz == classzz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        Class dateClass = Date.class;
        try {
            //object 是 java.util.Date
            Object object = dateClass.newInstance();
            Date date = (Date)object;
            System.out.println(object);
            System.out.println(object instanceof Date);
            System.out.println(object.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    
    }
}
