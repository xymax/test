package com.bittech.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class TestMyCallable {
    
    public static void main(String[] args) {
        
        Callable<Integer> callable = new MyCallable();
        
        //Runnable  -> run  -> void
        //Callable  -> run (异步) -> V(int) 将来
        
        //FutureTask  -> Runnable
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        
        Thread thread = new Thread(futureTask);
        thread.start();
        
        try {
            Integer sum = futureTask.get(1, TimeUnit.MILLISECONDS);
            System.out.println(sum);
        } catch (InterruptedException e) {//中断
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("main结束");
        
    }
}
