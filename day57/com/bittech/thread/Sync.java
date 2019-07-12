package com.bittech.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 21:04
 * @Description:
 */
class SyncTest implements Runnable {
    private Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName()+"开始执行..");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "执行结束..");
        }

    }
}
public class Sync {
    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        Thread thread1 = new Thread(syncTest,"线程A");
        Thread thread2 = new Thread(syncTest,"线程B");
        Thread thread3 = new Thread(syncTest,"线程C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
