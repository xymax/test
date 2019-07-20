package com.bittech.thread;

/**
 * @Author: yuisama
 * @Date: 2019-07-04 19:52
 * @Description:
 */
class Pen{}
class Book{}
public class DeadLock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread penThread = new Thread(() -> {
            synchronized (pen) {
                System.out.println("我有笔，把本给我！");
                synchronized (book) {
                    System.out.println("把你的本子给我!");
                }
            }
        });
        Thread bookThread = new Thread(() -> {
            synchronized (book) {
                System.out.println("我有本，把笔给我!");
                synchronized (pen) {
                    System.out.println("把你的笔给我！");
                }
            }
        });
        penThread.start();
        bookThread.start();
    }
}
