package com.bittech.api;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class NotifyThread extends Thread {
    
    private final Object object;
    
    public NotifyThread(Object object) {
        this.object = object;
    }
    
    @Override
    public void run() {
        synchronized(this.object){
            System.out.println(Thread.currentThread().getName()+ " 开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            this.object.notify();
            this.object.notifyAll();
            System.out.println(Thread.currentThread().getName() +" 结束执行");
        }
    }
}
