package com.xy.factory.抽象;

public class XiaoMiLuYou implements LuyouqiProduct {
    @Override
    public void OpenWiFi() {
        System.out.println("打开WiFi");
    }

    @Override
    public void OpenSetting() {
        System.out.println("打开设置");
    }
}
