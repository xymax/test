package com.xy.Runable.demo04;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            // Thread.sleep(1000);
            Thread.yield();
            System.out.println("��ǰ�߳�" + Thread.currentThread().getName() + "  i=" + i);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
