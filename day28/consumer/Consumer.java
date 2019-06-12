package com.bittech.consumer;

import com.bittech.common.Goods;

import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class Consumer implements Runnable {
    
    private final Queue<Goods> queue;
    
    public Consumer(Queue<Goods> queue) {
        this.queue = queue;
    }
    
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this.queue) {
                if (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 容器已空 停下消费 加速生成");
                    this.queue.notifyAll();
                } else {
                    Goods goods = this.queue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread().getName() + " 消费商品 " + goods);
                    }
                }
            }
        }
    }
}
