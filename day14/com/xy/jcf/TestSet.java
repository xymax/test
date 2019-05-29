package com.biitech.jcf;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: secondriver
 * Created: 2019/5/29
 */
public class TestSet {
    
    public static void code1(){
        Set<String> set  =new HashSet<>();
        set.add("Java");
        set.add("C++");
        set.add("PHP");
        set.add("SQL");
        set.add("JavaScript");
        set.add("C");
        set.add("Python");
        set.add("C++");
        set.add("C"); //9  2  7
        System.out.println("集合元素个数："+set.size());
        System.out.println("集合是否为空："+set.isEmpty());
        System.out.println("集合元素："+set);
        System.out.println("移除SQL:"+set.remove("SQL"));
        System.out.println("是否包含Java:"+set.contains("Java"));
    }
    
    
    public static void main(String[] args) {
//        Set<String> set  =new TreeSet<>();
//        set.add("Java");
//        set.add("C++");
//        set.add("PHP");
//        set.add("SQL");
//        set.add("JavaScript");
//        set.add("C");
//        set.add("Python");
//
//        System.out.println(set);
        
        
//        Set<Integer> set = new TreeSet<>();
//        set.add(50);
//        set.add(25);
//        set.add(30);
//        set.add(18);
        //已知升序
        
        //1. JDK中定义的类的实例化对象在TreeSet  如何改变
        //2. TreeSet中使用了自定义类型，排序是要求
        // a. 实现Comparable接口
        // b. 在TreeSet实例化的时候指定Comparator
        
        Set<Person2> set = new TreeSet<>(Comparator.comparingInt(o -> o.getName().length()));
        
        set.add(new Person2("Jack",22));
        set.add(new Person2("Tom",21));
        set.add(new Person2("Alice",24));
        set.add(new Person2("张三",20));
        System.out.println(set);
    }
}
