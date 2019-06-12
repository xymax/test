package com.bittech.executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: secondriver
 * Created: 2019/6/12
 */
public class TestExecutors {
    
    public static void main(String[] args) {
        
        //固定线程数
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //单线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        
        //无限制线程数
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//
//        for (int i = 0; ; i++) {
//            executorService.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().toString());
//            });
//
//        }
        
        
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        //固定延迟执行任务
//        service.scheduleWithFixedDelay(() -> {
//            System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd " +
//                    "HH:mm:ss")));
//        }, 0L, 2L, TimeUnit.SECONDS);
        
        //在某个时间点执行任务
        System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd " +
                "HH:mm:ss")));
        
        service.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd " +
                    "HH:mm:ss")));
        }, 2L, TimeUnit.SECONDS);
        
        
    }
}
