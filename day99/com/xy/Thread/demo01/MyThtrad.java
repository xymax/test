package com.xy.Thread.demo01;

public class MyThtrad extends Thread {
    private String title;

    public MyThtrad(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "  i=" + i);
        }
    }


    public static void main(String[] args) {
        MyThtrad myThtrad1=new MyThtrad("thread1");
        MyThtrad myThtrad2=new MyThtrad("thread2");
        MyThtrad myThtrad3=new MyThtrad("thread3");
        myThtrad1.start();
        myThtrad2.start();
        myThtrad3.start();
    }

}
