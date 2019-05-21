package com.bittech.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestClass {
    
    public static void part1() {
        //1. new Test1().getClass();
        //2. Test1.class
        //3. Class.forName("com.bittech.reflect.Test1")
        Class clz = Test1.class;
        
        System.out.println("包名：" + clz.getPackage().getName());
        System.out.println("父类：" + clz.getSuperclass().getName());//类的全限定名 包名.类名
        System.out.println("父类：" + clz.getSuperclass().getSimpleName());//类名
        System.out.println("接口：");
        Class[] interfaces = clz.getInterfaces();
        for (Class cls : interfaces) {
            System.out.println(cls.getName());
            System.out.println(cls.getSimpleName());
        }
    }
    
    
    public static void main(String[] args) {
        //Test1(int a, int b);    => Test1(int, int) => Test1(int.class, int.class)
        //Test1(int a, String b); => Test1(int,String)
        //Test1(int a);           => Test1(int)
        Class clz = Test1.class;
        //获取所有的构造方法
        Constructor[] constructors = clz.getConstructors();
        System.out.println("获取所有的构造方法");
        for (Constructor c : constructors) {
            Class[] parameterCls = c.getParameterTypes();
            String parameter = Arrays.toString(parameterCls);
            System.out.println(
                    c.getName() +
                            "(" + parameter + ")"
            );
        }
        
        System.out.println("获取指定的构造方法");
        try {
            /*
            Constructor constructor = clz.getConstructor(Integer.class, String.class);
            System.out.println(constructor);
            
            //通过Constructor实例化对象
            //new Test(...)
            Object object = constructor.newInstance(20, "Java");
            System.out.println(object.getClass());
            */
            Constructor constructor = clz.getConstructor(Integer.class, Integer.class);
            System.out.println(constructor);
            
            //通过Constructor实例化对象
            //new Test(...)
            Object object = constructor.newInstance(20, 22);
            System.out.println(object.getClass());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        
    }
    
}


interface Fruit1 {

}

interface Message1 {

}

//com.bittech.reflect
class Test1 implements Fruit1, Message1 {
    
    public Test1(Integer a, Integer b) {
    
    }
    
    public Test1(Integer a, String b) {
    
    }
    
    public Test1(Integer a) {
    
    }
    
    public Test1() {
    
    }
}

