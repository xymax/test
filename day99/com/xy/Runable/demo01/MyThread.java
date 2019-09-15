package com.xy.Runable.demo01;

public class MyThread implements Runnable {
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");
        MyThread myThread3 = new MyThread("thread3");

        // ���������ַ������ǵ��õ�Thread��start�����ſ����������̡߳�
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "  i=" + i);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
