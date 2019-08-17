package com.xy.demo02;
//* java8开始可以使用默认方法（解决接口升级的问题） 也可以被复写
//* 格式：
//* public default 返回值类型 方法名称（参数列表）{
//*    方法体
//*
//* }
//
//
//
public interface MyInterfaceDefult {
    void method();

     default void method2(){
        System.out.println("这是新添加的默认方法");
    }




}
