package com.xy.demo02;

public class Test {
    public static void main(String[] args) {
        MyInterfaceImpl a=new MyInterfaceImpl();
        a.method();//调用1抽象方法
        a.method2();//调用默认方法（类中没有会想上找接口的默认方法）

        System.out.println("===========");

        MyInterface2 b=new MyInterface2();
        b.method();
        b.method2();
    }

}
