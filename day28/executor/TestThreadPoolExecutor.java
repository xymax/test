package com.bittech.executor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: secondriver
 * Created: 2019/6/12
 */
public class TestThreadPoolExecutor {
    
    public static void main(String[] args) {
        //pool-1
        //pool-1-thread-0
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(),
                new ThreadFactory() {
                    final AtomicInteger id = new AtomicInteger(0);
                    
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("线程-" + id.getAndIncrement());
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy() //饱和策略
        );

//        for (int i = 0; i < 50; i++) {
//            final int tmp = i;
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " " + tmp);
//                }
//            });
//        }
        
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            final Future<String> future = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));//0-5
                    return "任务编号：" + tmp + " 时间：" + LocalDateTime.now().toString();
                }
            });
            //将来执行的任务的结果处理放到集合
            futureList.add(future);
        }

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //假设sleep之后，任务都执行完成了
//        for (Future future : futureList) {
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        
        List<Runnable> runnables = executor.shutdownNow();
        System.out.println(runnables.size());
        System.out.println(executor.isShutdown());
        System.out.println(executor.isTerminated());
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(executor.isTerminated());
        
        //1.循环
//        while (executor.isTerminated()) {
//            break;
//        }
        //2.定时检查
        
    }
}
