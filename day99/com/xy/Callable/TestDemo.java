package com.xy.Callable;

import org.omg.IOP.TAG_JAVA_CODEBASE;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task =new FutureTask<>(new MyThread());
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}

