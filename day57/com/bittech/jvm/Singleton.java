package com.bittech.jvm;

/**
 * @Author: yuisama
 * @Date: 2019-07-08 19:06
 * @Description:
 */
public class Singleton {
    private int age;
    private String name;
    private static volatile Singleton singleton;
    private Singleton() {
        age = 20;
        name = "zs";
    }
    public static Singleton getInstance() {
        // 线程2
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    // 线程1
                    // a.堆开空间
                    // c.栈开空间指向堆内存(single != null)
                    // b.属性初始化
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
