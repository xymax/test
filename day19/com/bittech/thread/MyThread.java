package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/6/3
 */
public class MyThread extends Thread {
    
    private final String title;
    
    public MyThread(String title) {
        this.title = title;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}
