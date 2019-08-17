package com.xy.demo03;
/*
* 不能通过接口实现类的对象来调用接口中的静态方法
*
* 正确方法
* 用接口名称.静态方法
*
*
* */
public class Test implements MyInterfaceImpl{
    public static void main(String[] args) {
        Test test=new Test();



        MyInterfaceImpl.method();
    }
}
