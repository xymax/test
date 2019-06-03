package com.bittech.thread;

import java.util.concurrent.Callable;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        Thread.sleep(1000);
        return sum;
    }
}
