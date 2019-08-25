package com.xy.Ineger;
/*
*
* 装箱就是将基本类型装换为引用类型
* 拆箱就是将引用类型转化为基本类型
* */
public class TestDemo02 {
    public static void main(String[] args) {

        /*
        * 装箱
        * 1.构造方法
        * 2.静态方法  类名.valueOf()
        *
        *
        * */
        //构造方法
        Integer integer=new Integer(1);
        System.out.println(integer); //重写了toString方法

        //静态方法
        Integer integer1 = Integer.valueOf(1);
        System.out.println(integer1);

        /*
        * 拆箱
        *   .intValue
        *
        *
        *
        * */
        int i = integer1.intValue();
        System.out.println(i);


    }

}
