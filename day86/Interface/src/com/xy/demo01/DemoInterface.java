package com.xy.demo01;
/*
*
* 1.接口定义：
* 接口就是多个类的公共规范
* 接口是一种引用类型，其中最重要的就是其中的抽象方法
*
* 格式：
* public interface 接口名称{
*
*   接口内容（包含常量，抽象方法，默认方法，静态方法（jdk8） ，，私有方法（jdk9））
*
* }
*
*
* */
public class DemoInterface implements IAbstract{
    @Override
    public void method() {
        System.out.println("第一个方法");

    }

    @Override
    public void method2() {
        System.out.println("第二个方法");


    }

}
