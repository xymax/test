package com.bittech.thread.tick;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class MyTickRunnable implements Runnable {
    
    private int tick = 10;
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.currentThread().getName() 那个线程在执行代码 ，返回线程的名字
            synchronized(this) {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "买了一张票，剩余" + (--this.tick));
                }
                
            }
        }
        
    }
}
