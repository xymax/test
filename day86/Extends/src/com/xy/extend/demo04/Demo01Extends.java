package com.xy.extend.demo04;
/*
* 父子类方法重名，创建对象是谁，就用谁，没有向上找。不会向下找
* 重写：（Override）复写
* 概念：在继承关系中，方法名称一样，参数列表【也一样。】
* 特点，创建的是子类对象，则有优先使用子类方法 new谁先用谁
*
*
* 重载（Overload）
* 方法名称一样，参数列表【不一样】
*
* */
public class Demo01Extends {

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.methodfu();
        zi.methodzi();
        System.out.println("==========");
        zi.method();
    }
}
