package com.bittech.api;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class TestWait {
    
    final static Object object = new Object();
    
    public static void code1() {
        synchronized(object) {
            System.out.println("同步开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步结束");
        }
        System.out.println("main方法执行结束");
    }
    
    public static void main(String[] args) {
        System.out.println("同步开始");
        try {
            object.wait();//IllegalMonitorStateException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步结束");
    }
}
