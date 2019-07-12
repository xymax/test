package com.bittech.test;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 19:21
 * @Description:Java中创建线程的方式
 */
class Task implements Runnable {
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("1")) {
            testA();
        }else
            testB();
    }
    public synchronized void testA() {
        // m = 1
        System.out.println("线程1在运行...");
        // m = 2
        testB();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void testB() {
        System.out.println("线程2在运行...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task,"1");
        Thread thread2 = new Thread(task,"2");
        thread1.start();
        thread2.start();
    }
}
