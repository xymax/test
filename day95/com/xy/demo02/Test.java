package com.xy.demo02;
/*
*
* 1.访问成员变量的两种方法
* 直接访问对象名称访问成员变量，看等号左边是谁就优先用谁，没有就向上找
* 间接通过成员方法访问成员变量，看方法属于谁就，优先用谁，没有就向上找。
*
*
*
*
*
* */
public class Test {
    public static void main(String[] args) {

        Fu x=new Zi();
        //1.第一种方法
        System.out.println(x.num); //10   看等号左边是谁。

        System.out.println("===============");

        //第二种方法。
        x.method(); //如果没有覆盖重写，就是访问父类覆盖重写就是访问子类的



    }
}
