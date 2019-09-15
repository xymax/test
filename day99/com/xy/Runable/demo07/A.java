package com.xy.Runable.demo07;

public class A implements Runnable{


    @Override
    public void run() {
        System.out.println("线程A的优先级"+Thread.currentThread().getPriority());
        Thread thread=new Thread(new B());
        thread.start();
    }
}
