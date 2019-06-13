package com.bittech.api;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class WaitThread extends Thread {
    
    private final Object object;
    
    
    public WaitThread(Object object) {
        this.object = object;
    }
    
    @Override
    public void run() {
        synchronized(this.object) {
            System.out.println(Thread.currentThread().getName() + " 开始执行");
            try {
                this.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 结束执行");
        }
    }
}
