package com.xy.Static;

//静态方法总是优先于构造方法执行
//静态代码块只会执行一次，第一次使用此类的时候执行。之后就不会再执行。
//使用场景：用来一次性对静态变量进行赋值。

public class Demo04Static {


    public static void main(String[] args) {
        Penson2 one=new Penson2();
        Penson2 two=new Penson2();

    }
}
