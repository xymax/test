package com.xy.Runable.demo07;

import sun.awt.windows.ThemeReader;

public class B implements Runnable {
    @Override
    public void run() {
        System.out.println("线程B的优先级"+Thread.currentThread().getPriority());
    }
}
