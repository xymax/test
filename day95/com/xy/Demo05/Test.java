package com.xy.Demo05;

public class Test {
    public static void main(String[] args) {
        //创建一个笔记本
        ComputerImpl computer=new ComputerImpl();
        computer.开机();
        computer.关机();


        //准备一个鼠标给电脑用
        ShuBiao shuBiao=new ShuBiao();
        //向上转型
        Usb usb=new ShuBiao();//多态。
        computer.usbDriver(shuBiao);

        //创建一个键盘
        JP jp=new JP();
        computer.usbDriver(jp);

    }
}
