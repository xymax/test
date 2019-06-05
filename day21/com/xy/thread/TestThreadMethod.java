package com.bittech.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: secondriver
 * Created: 2019/6/5
 */
public class TestThreadMethod {
    
    public static void code1() {
        Thread thread1 = new ThreadMethod();
        thread1.setName("打印输出线程");
        thread1.start();
        
        for (int i = 0; i < 10; i++) {
            Runnable runnable1 = new RunnableMethod();
            Thread thread2 = new Thread(runnable1, "线程-" + i);
//            thread2.setName("业务线程-" + i);
            thread2.start();
        }
        //Thread-[业务名称]
        
        //主程序（程序入口）线程main
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        
        //main -> Thread(main)
        //Java程序 -> 进程  -> JVM -> 程序入口  -> main(线程)
        //main; 自动回收内存，GC (线程)
    }
    
    public static void code2() {
        new Thread(() -> {
            System.out.println("Start : " + LocalDateTime.now());//java.time.*(新的时间API)  java.util.*(旧的时间API)
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("End : " + LocalDateTime.now());
        }, "Thread-Sleep")
                .start();
    }
    
    
    public static void code4() {
        Runnable runnable = () -> {
            System.out.println("Start : " + LocalDateTime.now());//java.time.*(新的时间API)  java.util.*(旧的时间API)
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Thread.yield();
            }
            System.out.println("End : " + LocalDateTime.now());
        };
        
        new Thread(runnable, "Thread-Sleep-1").start();//sleep
        
        new Thread(runnable, "Thread-Sleep-2").start();//sleep
        
        new Thread(runnable, "Thread-Sleep-3").start();//sleep
        
        //单核CPU
    }
    
    public static void code5() {
        Thread thread = new Thread(new RunnableJoin(), "Thread-B");
        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " main中的代码");
    }
    
    
    public static void code6() {
        //2019-06-05 19:57:20
        //2019/06/05 19:57:20
        //2019年06月0日 19:57:20
        /*
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
        );
        System.out.println(format.format(date));
         */
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));//date  time  datetime
        
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
    }
    
    public static void code7() {
        RunnableStop runnableStop = new RunnableStop();
        Thread thread = new Thread(runnableStop, "Thread-Stop-1");
        thread.start();
        
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " code");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        runnableStop.setFlag(false);
//        thread.stop();
        thread.interrupt();
        System.out.println(Thread.currentThread().getName() + " 代码执行完啦");
    }
    
    
    public static void code8() {
        //        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " 优先级 " + Thread.currentThread().getPriority()),
//                "Thread-1");
        //1-10  1 低  5 中等  10 高
//        thread1.setPriority(10);
//        thread1.start();
        
        System.out.println(Thread.currentThread().getPriority());
        
        //main  默认优先级5
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 优先级 " + Thread.currentThread().getPriority());
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " 优先级 " + Thread.currentThread().getPriority());
                        
                    }
                }, "Thread-Parent-A-Name-is-B").start();
            }
        }, "Thread-Parent-Main-Name-is-A").start();
        
        
    }
    
    public static void main(String[] args) {
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                }
            }
        });
        //必须在线程启动之前调用
        thread.setDaemon(true);
        thread.start();
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                }
            }
        });
        
        thread2.start();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
        System.out.println("main代码结束");
    }
    
}


class ThreadMethod extends Thread {
    @Override
    public void run() {
        //this  ThreadMethod类的对象， getName()获取当前线程的名称
        System.out.println(this.getName() + " thread(extends)");
    }
}

class RunnableMethod implements Runnable {
    
    @Override
    public void run() {
        //运行run方法的线程名称
        //Thread对象   Thread.currentThread()
        System.out.println(Thread.currentThread().getName() + "  runnable(implements)");
    }
}


class RunnableJoin implements Runnable {
    
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 执行开始时间 ：" + LocalDateTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 假装这里有大量代码");
        System.out.println(Thread.currentThread().getName() + " 执行结束时间 ：" + LocalDateTime.now());
        
    }
}

class RunnableStop implements Runnable {
    
    private boolean flag = true;
    
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1000);//阻塞
                //非阻塞
                //此处有代码
                boolean status = Thread.currentThread().isInterrupted();
                if (status) {
                    System.out.println("非阻塞状态 " + status);
                    break;
                }
                i++;
                System.out.println(Thread.currentThread().getName() + " 运行了 " + i + " 次");
            } catch (InterruptedException e) {
                e.printStackTrace();
                //阻塞状态
                boolean status = Thread.currentThread().isInterrupted();
                //false 中断标志位清除
                System.out.println("阻塞状态 " + status);
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " 终于停了");
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}