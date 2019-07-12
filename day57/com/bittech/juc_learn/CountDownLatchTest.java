package com.bittech.juc_learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-07 15:08
 * @Description:
 */
class CDLTask implements Runnable {
    private CountDownLatch countDownLatch;

    public CDLTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+
                "到达终点");
        countDownLatch.countDown();
    }
}
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CDLTask task = new CDLTask(countDownLatch);
        System.out.println("比赛开始...");
        Thread thread = new Thread(task, "运动员A");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(task, "运动员B");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread3 = new Thread(task, "运动员C");
        thread3.start();
        TimeUnit.SECONDS.sleep(1);
        // 裁判需要等所有运动员到达终点后继续执行此语句
        countDownLatch.await();
        System.out.println("比赛结束..");
    }
}
