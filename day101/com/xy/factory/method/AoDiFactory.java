package com.xy.factory.method;

public class AoDiFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new AoDi();
    }
}
