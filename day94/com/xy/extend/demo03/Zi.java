package com.xy.extend.demo03;

public class Zi extends Fu {
    int num=20;


    public void methodzi(){
        int num=30;
        System.out.println(num);//局部变量
        System.out.println(this.num); //本类成员变量
        System.out.println(super.num); //父类成员变量

    }
}
