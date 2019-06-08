package com.bittech.thread.sync;

/**
 * Author: secondriver
 * Created: 2019/6/8
 */
public class TestSync {
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new SyncThread2();
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }
    }
}

class Sync {
    //多线访问同一个Sync对象的test方法，同一时间只能有一个线程方法
    //成员方法（非静态方法）=> 类的实例化对象
    //静态方法 => 类
    public synchronized void test() {
        System.out.println("Sync test方法在线程：" + Thread.currentThread().getName() + " 开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync test方法在线程：" + Thread.currentThread().getName() + " 结束执行");
    }
}


class Sync1 {
    public void test() {
        //Sync1.class -> 只有一个
        //Sync1.class -> Class 对象  -> Sync1 -> 全局锁
        synchronized(Sync1.class) {
            System.out.println("Sync test方法在线程：" + Thread.currentThread().getName() + " 开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync test方法在线程：" + Thread.currentThread().getName() + " 结束执行");
        }
    }
}

class SyncThread extends Thread {
    
    private final Sync sync;
    
    SyncThread(Sync sync) {
        this.sync = sync;
    }
    
    @Override
    public void run() {
        sync.test();
    }
}

class SyncThread1 extends Thread {
    
    private final Sync1 sync;
    
    public SyncThread1(Sync1 sync) {
        this.sync = sync;
    }
    
    @Override
    public void run() {
//        synchronized(sync) {
//            sync.test();
//        }
        sync.test();
    }
}

class SyncThread2 extends Thread {
    
    @Override
    public void run() {
        //实例化多个Sync1对象，sync1.test
        Sync1 sync1 = new Sync1();
        sync1.test();
    }
}