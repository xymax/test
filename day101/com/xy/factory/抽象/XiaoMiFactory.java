package com.xy.factory.抽象;

public class XiaoMiFactory implements IProduFactory {
    @Override
    public IphoneProduct productIphone() {
        return new XiaoMiPhone();
    }

    @Override
    public LuyouqiProduct productLuyou() {
        return new XiaoMiLuYou();
    }
}
