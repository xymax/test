package com.xy.chouxinaglei.demo01;
/*
* //当方法不具体的时候就可以使用抽象方法
* 抽象方法，就是加上abstract关键字，然后去掉大括号，直接分号结束。
* 抽象类：抽象方法所在的类必须是抽象类。在class前加上abstract，可以在抽象类中写普通方法
*
*
*
* 如何使用抽象类和抽象方法
* 1.不能直接new抽象类对象
*
* */
public  abstract class Animal {

    public  abstract void eat();

    public void method(){
        System.out.println("普通方法");
    }


}
