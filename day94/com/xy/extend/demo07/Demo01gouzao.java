package com.xy.extend.demo07;
/*
*
* 1.父子类构造方法访问特点
*子类构造方法中有个默认的super（）调用。所以一定是先调用父类构造方法，后执行子类构造 。
*
* 2.可以通过super关键字子类调用父类重构造。
*
* 3.super的父类构造必须是子类构造的第一个语句。不能一个子类构造调用多个super构造。
*
* 总结：
* 子类必须调用父类构造方法，不写则赠送super关键字。super只能有一个，而且只能是第一个
*
* */
public class Demo01gouzao {
    public static void main(String[] args) {
        Zi zi=new Zi();


    }


}
