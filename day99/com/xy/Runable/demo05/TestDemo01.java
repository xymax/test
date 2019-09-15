package com.xy.Runable.demo05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

/*
* Join()方法：线程终止
* 等待该线程终止。意思就是如果在主线程中调用该方法时就会让主线程休眠，
* 让调用该方法的线程run方法先执行完毕之后在开始执行主线程
*
* */
public class TestDemo01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt     = new MyThread();
        Thread   thread = new Thread(mt, "子线程A");

        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("代码结束");
    }

    public static void printTime() {
        Date       date   = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String     time   = format.format(date);

        System.out.println(time);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
