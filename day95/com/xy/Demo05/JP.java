package com.xy.Demo05;

public class JP implements Usb{
    @Override
    public void 开设备() {
        System.out.println("打开jp");

    }

    @Override
    public void 关设备() {
        System.out.println("关闭键盘");

    }

    public void 敲击(){
        System.out.println("敲键盘");
    }
}
