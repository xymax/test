package com.xy.Runable.demo01;

public class TestDemo02 {

    // 使用Lamdba表达式创建多线程
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello world");

        new Thread(runnable).start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
