package com.xy.Runable.demo01;

public class TestDemo01 {

    // ʹ�������ڲ��ڴ������߳�
    public static void main(String[] args) {
        new Thread(new Runnable() {
                       @Override
                       public void run() {
                           System.out.println("hello world");
                       }
                   }).start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
