package com.xy.chouxinaglei.demo02;

public class Dog2哈 extends Dog{
    public static void main(String[] args) {
        Dog2哈 dog2哈=new Dog2哈();
        dog2哈.eat();
        dog2哈.sleep();
    }
    @Override
    public void sleep() {
        System.out.println("睡觉不存在，我要拆家");
    }


}
