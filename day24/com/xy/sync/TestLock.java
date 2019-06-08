package com.bittech.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: secondriver
 * Created: 2019/6/8
 */
public class TestLock {
    /*
        lock
           c++
           java
           ds
           mysql
        unlock
        
        lock
          game
        unlock
        
        //加锁，解锁，异常情况正常解锁
        //开始事务 CURD  (回滚，提交） 结束事务
     */
    
    public static void main(String[] args) {
        Runnable runnable = new TickLockRunnable();
        
        new Thread(runnable, "黄牛A").start();
        new Thread(runnable, "黄牛B").start();
        new Thread(runnable, "黄牛C").start();
        
        
    }
    
}

class TickLockRunnable implements Runnable {
    
    private int tick = 10;
    
    private final Lock lock = new ReentrantLock();
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //code
//            this.tick
//            this.lock.lock();
//            if (this.tick > 0) {
//                System.out.println(Thread.currentThread().getName() + " 买票 剩余 " + (--this.tick));
//            }
//            this.lock.unlock();
            this.lock.lock();
            try {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + " 买票 剩余 " + (--this.tick));
                }
                //此处业务逻辑
            } finally {
                this.lock.unlock();//一定会释放
            }
        }
    }
}