package com.xy.extend.demo02;
/*
* 父子继承关系中，若是成员变量重名，创建子类对象时，访问有两种方式
* 2.直接通过子类访问成员变量，(等号左边是谁就优先用谁，没有就向上找)
* 间接通过成员方法访问成员变量，没有向上找（改方法属于谁就优先用谁，没有向上找）
*
*
* */
public class Demo01Extend {

    public static void main(String[] args) {
        Fu fu = new Fu();
        System.out.println(fu.numfu);
        System.out.println("===================");
        Zi zi=new Zi();
        System.out.println(zi.numfu);
        System.out.println(zi.numzi);


        System.out.println("=============");

        System.out.println(zi.num); //优先子类 10
        System.out.println(zi.x); //子类没有想上找  50

        System.out.println("================");

        zi.methodfu();
        zi.methodzi();



    }
}
