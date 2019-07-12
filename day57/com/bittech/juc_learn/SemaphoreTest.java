package com.bittech.juc_learn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-07 15:49
 * @Description:
 */
class SemaphoreTask implements Runnable {
    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        // 尝试获取设备进行生产
        try {
            semaphore.acquire(2);
            System.out.println(Thread.currentThread().getName()+"正在占用设备生产");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+"生产完毕，释放设备");
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreTest {
    public static void main(String[] args) {
        int workers = 8;
        Semaphore semaphore = new Semaphore(5);
        SemaphoreTask task = new SemaphoreTask(semaphore);
        for (int i = 0;i < workers;i++) {
            new Thread(task,"工人"+(i+1)).start();
        }
    }
}
