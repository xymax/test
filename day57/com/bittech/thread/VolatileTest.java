package com.bittech.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-07 17:35
 * @Description:
 */
public class VolatileTest {
    private volatile int num = 0;
    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        Thread[] threads = new Thread[10];
        for (int i = 0;i < 10;i++) {
            threads[i] = new Thread(() -> {
               for (int j = 0;j < 100;j++) {
                   try {
                       TimeUnit.MILLISECONDS.sleep(20);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   // num = num + 1;
                   test.num ++;
               }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(test.num);
    }
}
