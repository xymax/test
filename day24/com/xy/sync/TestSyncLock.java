package com.bittech.thread.sync;

/**
 * Author: secondriver
 * Created: 2019/6/8
 */
public class TestSyncLock {
    
    public static void main(String[] args) {
        final Object lock = new Object();//同一个对象
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    System.out.println(Thread.currentThread().getName() + "执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "执行结束");
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    System.out.println(Thread.currentThread().getName() + "执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "执行结束");
                }
            }
        }, "线程B").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    System.out.println(Thread.currentThread().getName() + "执行开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "执行结束");
                }
            }
        }, "线程C").start();
    }
    
}


