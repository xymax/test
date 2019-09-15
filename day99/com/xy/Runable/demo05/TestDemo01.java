package com.xy.Runable.demo05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

/*
* Join()�������߳���ֹ
* �ȴ����߳���ֹ����˼������������߳��е��ø÷���ʱ�ͻ������߳����ߣ�
* �õ��ø÷������߳�run������ִ�����֮���ڿ�ʼִ�����߳�
*
* */
public class TestDemo01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt     = new MyThread();
        Thread   thread = new Thread(mt, "���߳�A");

        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("�������");
    }

    public static void printTime() {
        Date       date   = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String     time   = format.format(date);

        System.out.println(time);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
