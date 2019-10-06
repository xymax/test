package com.xy.factory.method;

public class Consumer {
    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car1 = new BaoMaFactory().getCar();
        Car car2 = new AoDiFactory().getCar();


        car.name();
        car1.name();
        car2.name();
    }
}
