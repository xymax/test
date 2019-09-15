package com.xy.Runable.demo07;

public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程："+Thread.currentThread().getName()+"  i="+i);
        }
    }






}
