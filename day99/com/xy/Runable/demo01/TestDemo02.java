package com.xy.Runable.demo01;

public class TestDemo02 {

    // ʹ��Lamdba���ʽ�������߳�
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello world");

        new Thread(runnable).start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
