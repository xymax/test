package com.xy.Runable.demo04;

/*
* 线程休眠 :休眠时间使用毫秒作为单位。
*
* 线程休眠会交出CPU，让CPU去执行其他的任务。但是有一点要非常注意，sleep方法不会释放锁，
* 也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象
*
*通过代码观察会错误的认为这三个线程是同时休眠的，但是千万要记住，
*所有的代码是依次进入到run()方法中的.真正进入到方法的对象可能是多个，
*也可能是一个。进入代码的顺序可能有差异，但是总体的执行是并发执行。
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread, "线程1").start();
        new Thread(myThread, "线程2").start();
        new Thread(myThread, "线程3").start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
