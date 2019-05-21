package com.bittech.classloader;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestMyClassLoader {
    
    public static void main(String[] args) {
        //Member1 -> AppClassLoader  -> Class<Member1> a
        //Member1 -> AppClassLoader  -> Class<Member1> b
        //Member1 -> AppClassLoader  -> Class<Member1> c
        
        //Member1 -> MyClassLoader  -> Class<Member1>  d
        MyClassLoader myClassLoader = new MyClassLoader();
        
        //Class
        Class member1Cls1 = myClassLoader.loadClasses("com.bittech.classloader.Member1");
        //Class
        Class member1Cls2 = Member1.class;
        Class member1Cls3 = new Member1().getClass();
        System.out.println(member1Cls1 == member1Cls2);
        System.out.println(member1Cls2 == member1Cls3);
        
    }
    
}
