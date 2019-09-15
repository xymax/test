package com.xy.Runable.demo01;

public class TestDemo01 {

    // 使用匿名内部内创建多线程
    public static void main(String[] args) {
        new Thread(new Runnable() {
                       @Override
                       public void run() {
                           System.out.println("hello world");
                       }
                   }).start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
