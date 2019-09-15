package com.xy.Runable.demo06;
/*
 * 1. 设置标记位，可以是线程正常退出。
 * 2. 使用stop方法强制使线程退出，但是该方法不太安全所以已经被废弃了。
 * 3. 使用Thread类中的一个interrupt() 可以中断线程。
 * */


import java.util.LinkedList;
import java.util.Stack;

public class MyThread implements Runnable {
    private boolean flag = true;

    public MyThread(boolean flag) {
        this.flag = flag;
    }

    public MyThread() {

    }

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                Thread.sleep(100);
                System.out.println("第" + i + "次执行" + "线程名为" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}




