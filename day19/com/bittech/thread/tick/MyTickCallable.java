package com.bittech.thread.tick;

import java.util.concurrent.Callable;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class MyTickCallable implements Callable<String> {
    
    private int tick = 10;
    
    @Override
    public String call() {
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
        return "票卖光了";
    }
}
