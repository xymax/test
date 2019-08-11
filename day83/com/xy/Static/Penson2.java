package com.xy.Static;
/*
* 静态代码块
* 特点：第一次用到本类时候，静态静态代码块会被引用，只会引用一次。
*
*
* */
public class Penson2 {
    static {
        System.out.println("静态代码块执行！");
    }
    public Penson2(){
        System.out.println("构造方法执行");
    }


}
