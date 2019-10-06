package com.xy.factory.method;

public class WuLingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
