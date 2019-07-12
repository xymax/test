package com.bittech.juc_learn;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yuisama
 * @Date: 2019-07-07 15:40
 * @Description:
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread grilThread = new Thread(() -> {
            try {
                String gril = exchanger.exchange("我暗恋你很久了...");
                System.out.println("女生说:"+gril);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        grilThread.start();
        Thread boyThread = new Thread(() -> {
            System.out.println("女神缓缓映入眼帘...");
            try {
                TimeUnit.SECONDS.sleep(1);
                String boy = exchanger.exchange("我喜欢你!");
                System.out.println("男生说:"+boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        boyThread.start();
    }
}
