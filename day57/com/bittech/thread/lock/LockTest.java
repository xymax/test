package com.bittech.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yuisama
 * @Date: 2019-07-04 20:34
 * @Description:
 */
class Task implements Runnable {
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        boolean isLock = false;
        try {
            if (lock.tryLock(2,TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName()+
                        "获取锁成功");
                TimeUnit.SECONDS.sleep(3);
                isLock = true;
            }else {
                System.out.println(Thread.currentThread().getName()+
                        "获取锁失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (isLock) {
                lock.unlock();
                System.out.println("锁已释放");
            }
        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task,"线程A");
        Thread thread1 = new Thread(task,"线程2");
        thread.start();
        thread1.start();
    }
}
