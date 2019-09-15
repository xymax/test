package com.xy.Runable.demo07;

import java.util.HashMap;

public class TestDemo01 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread thread1=new Thread(myThread,"线程1");
        Thread thread2=new Thread(myThread,"线程2");
        Thread thread3=new Thread(myThread,"线程3");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(1);
        thread1.start();
        thread2.start();
        thread3.start();
        HashMap.SimpleImmutableEntry
    }
}
