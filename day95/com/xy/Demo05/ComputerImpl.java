package com.xy.Demo05;

public class ComputerImpl  {
    public void 开机(){
        System.out.println("开机");
    }
    public void 关机(){
        System.out.println("关机");
    }


    //使用usb设备的方法,使用接口作为方法的参数

    public void usbDriver(Usb usb){
        usb.开设备();
        usb.关设备();
    }
}
