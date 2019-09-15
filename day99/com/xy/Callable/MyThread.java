package com.xy.Callable;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int tacket=10;
    @Override
    public String call() throws Exception {
        while (this.tacket>0){
            System.out.println("剩余票数"+this.tacket--);
        }
        return "票卖完了，欢迎下次购买";
    }

}
