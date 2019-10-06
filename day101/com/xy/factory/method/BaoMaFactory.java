package com.xy.factory.method;

public class BaoMaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BaoMa();
    }
}
