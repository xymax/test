package com.xy.factory.simple;

public class Consumer {
    public static void main(String[] args) {
/*        Car car=new WuLingHongGuang();
        Car car1=new BaoMa();
        car.name();
        car1.name();*/

//使用工厂创建
        Car car=CarFactory.getCar("五菱");
        Car car1=CarFactory.getCar("宝马");
        car.name();
        car1.name();




    }
}
