package com.bittech.thread;

import java.util.concurrent.*;

/**
 * @Author: yuisama
 * @Date: 2019-07-07 16:40
 * @Description:
 */
class JMMTask implements Runnable {
    private int ticket = 20;
    @Override
    public void run() {
        for (int i = 0;i < 20;i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName()
                            +"还剩下"+ticket--+"票");
                }
            }
        }
    }
}
public class ExecutorTest {
    public static void main(String[] args) {
        JMMTask task = new JMMTask();
        new Thread(task,"黄牛A").start();
        new Thread(task,"黄牛B").start();
        new Thread(task,"黄牛C").start();
    }
}
