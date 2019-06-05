package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class TestMyThread {
    
    public static void main(String[] args) {
    
        System.out.println("这是main方法的开始");
        MyThread myThread1 = new MyThread("MyThread1");
        MyThread myThread2 = new MyThread("MyThread2");
        MyThread myThread3 = new MyThread("MyThread3");
//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
        myThread1.start();
        myThread2.start();
        myThread3.start();
       
        System.out.println("这是main方法的结束");
    }
}
