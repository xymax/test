package com.xy.factory.抽象;

public class consumer {
    public static void main(String[] args) {
        IProduFactory xiaomifactory=new XiaoMiFactory();
        LuyouqiProduct xiaomiluyou=xiaomifactory.productLuyou();
        xiaomiluyou.OpenWiFi();
        xiaomiluyou.OpenSetting();


        IProduFactory huaweiFactory=new HuaWeiFactory();
        IphoneProduct huaweiPhone =huaweiFactory.productIphone();
        huaweiPhone.call();
        huaweiPhone.duanxing();


    }
}
