package com.xy.Demo05;
/*
* 鼠标就是一种usb设备
* */
public class ShuBiao implements Usb{
    @Override
    public void 开设备() {
        System.out.println("打开sb");

    }

    @Override
    public void 关设备() {
        System.out.println("关闭sb");

    }
    public void 敲击(){

        System.out.println("单击鼠标");
    }
}
