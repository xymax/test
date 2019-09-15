package com.xy.Thread.demo02;

public class MyThread extends Thread {
    private int tacket=10;

    @Override
    public void run() {
        while (this.tacket > 0) {
            System.out.println("剩余票数" + this.tacket--);
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

    }
}
