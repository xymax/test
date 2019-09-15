package com.xy.Runable.demo04;

/*
* 暂停当前正在执行的线程对象，并执行其他线程。
*
* 意思就是调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。
* 它跟sleep方法类似，同样不会释放锁。但是yield不能控制具体的交出CPU的时间，
* 另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会
*
* */
public class TestDemo02 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread, "线程1").start();
        new Thread(myThread, "线程2").start();
        new Thread(myThread, "线程3").start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
