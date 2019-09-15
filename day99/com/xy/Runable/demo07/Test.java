package com.xy.Runable.demo07;

public class Test {
    public static void main(String[] args) {
        Thread thread=new Thread(new A());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

    }
}
