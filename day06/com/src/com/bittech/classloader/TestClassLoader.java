package com.bittech.classloader;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestClassLoader {
    
    public static void main(String[] args) {
        Class memberCls = Member.class;
        //获取ClassLoader
        //AppClassLoader
        System.out.println(memberCls.getClassLoader());
        //ExtClassLoader
        System.out.println(memberCls
                .getClassLoader()
                .getParent()
        );
        //null -> Bootstrap ClassLoader
        System.out.println(memberCls
                .getClassLoader()
                .getParent()
                .getParent()
        );
        
    }
}

//1. com.bittech.classloader
//2. com.bittech.classloader.Member
//3. %classpath%/com/bittech/classloader/Member.class
//4. Member.class对象
class Member {

}