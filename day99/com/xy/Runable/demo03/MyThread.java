package com.xy.Runable.demo03;

public class MyThread implements Runnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread).start();
        new Thread(myThread).start();

        // new Thread(myThread,"线程1").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前对象" + Thread.currentThread().getName() + "i=" + i);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
