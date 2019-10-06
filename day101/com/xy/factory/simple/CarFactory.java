package com.xy.factory.simple;
//静态工厂模式
//增加一个新的产品，你不去修改代码的话，做不到。

//不满足开闭原则。

public class CarFactory {
    public static Car getCar(String car){
        if (car.equals("五菱")){

            return new WuLingHongGuang();
        }else if (car.equals("宝马")){
            return new BaoMa();
        }else {
            return null;
        }
    }
}
