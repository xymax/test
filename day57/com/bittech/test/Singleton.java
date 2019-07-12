package com.bittech.test;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 19:32
 * @Description:
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}
    public Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
