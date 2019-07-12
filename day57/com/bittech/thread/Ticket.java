package com.bittech.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 20:55
 * @Description:
 */
class Task implements Runnable {
    private int ticket = 20000;
    @Override
    public void run() {
        for (int i = 0;i < 20000;i++) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+
                            "还剩下"+ticket--+"票");
                }
            }
        }
    }
}
public class Ticket {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task,"黄牛A");
        Thread thread2 = new Thread(task,"黄牛B");
        Thread thread3 = new Thread(task,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
