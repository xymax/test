package com.xy.chouxinaglei.demo01;

/*
* * 如何使用抽象类和抽象方法
 * 1.不能直接new抽象类对象。
 * 2.必须用子类继承抽象父类
 * 3.子类必须复写父类所有抽象方法
*
*
* */
public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
