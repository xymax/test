package com.xy.demo03;
/*
*
* 多态代码成员方法的访问规则是
* 编译看左，运行看右边。
* */
public class Test {
    public static void main(String[] args) {
        Fu obj=new Zi();

        obj.method();  //编译看左边，运行看右边，左变通过编译，找的是右边的方法
        obj.method1();
      //  obj.method2();

    }
}
