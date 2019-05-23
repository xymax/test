package com.xy.hx.fanshe;

import java.util.Date;
//实例化对象 : 通过类的构造方法实例化对象（正向）
//获取Class  ： 通过实例化对象获取改对象的类（反向）

//Object 类中 getClass（）返回一个Class类型的对象；
//Class ：类型
public class TestReflect {
    public static void main(String[] args) {
        Date date=new Date();
        //类型
        //class 关键字
        //Class 类型
        //Java
        Class aClass=date.getClass();
        System.out.println(aClass);
        //如果data是Data类型 返回ture  否则 false
        System.out.println(date instanceof Date);
        Class classz=Date.class;

        //类的实例化对象
        //1. 通过构造方法实例化对象
        //2.通过反射创建类的实例化对象

    }

}
