package com.xy.factory.抽象;

public class HuaWeiIphone implements IphoneProduct {
    @Override
    public void call() {
        System.out.println("打电话");
    }

    @Override
    public void duanxing() {
        System.out.println("打短信");
    }
}
