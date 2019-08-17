package com.xy.chouxinaglei.demo01;
/*
* 如何使用抽象类和抽象方法
* 1.不能直接new抽象类对象。
* 2.必须用子类继承抽象父类
* 3.子类必须复写父类所有抽象方法
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        //Animal animal=new Animal(); //错误写法

        Cat cat=new Cat();
        cat.eat();

    }





}
