package com.xy.Runable.demo05;

import java.util.NoSuchElementException;

public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("�߳̿�ʼ��ʱ��");
            TestDemo01.printTime();
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
            System.out.println("�߳̽�����ʱ��");
            TestDemo01.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
