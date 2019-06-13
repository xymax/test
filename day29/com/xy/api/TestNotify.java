package com.bittech.api;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class TestNotify {
    public static void main(String[] args) {
        final Object object = new Object();
        Thread wait = new WaitThread(object);
        wait.setName("Thread-等待线程");
    
        Thread wait1 = new WaitThread(object);
        wait1.setName("Thread-等待线程1");
        Thread wait2 = new WaitThread(object);
        wait2.setName("Thread-等待线程2");
        
        Thread notify = new NotifyThread(object);
        notify.setName("Thread-通知线程");
        
        wait.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait1.start();
        wait2.start();
        notify.start();
    
    }
}
