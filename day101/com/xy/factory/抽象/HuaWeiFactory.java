package com.xy.factory.抽象;

public class HuaWeiFactory implements IProduFactory {
    @Override
    public IphoneProduct productIphone() {
        return new HuaWeiIphone();
    }

    @Override
    public LuyouqiProduct productLuyou() {
        return new HuaWeiLuYou();
}
}
