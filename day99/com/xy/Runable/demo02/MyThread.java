package com.xy.Runable.demo02;

public class MyThread implements Runnable {
    private int tacket = 10;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }

    @Override
    public void run() {
        while (this.tacket > 0) {
            System.out.println("Ê£ÓàÆ±Êı" + this.tacket--);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
