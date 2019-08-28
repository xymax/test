package com.xy.demo01;
/*
* 代码中实现多态性，其实就是一句话，父类引向子类对象
*
* 格式：
* 父类对象 对象名=new 子类名称（）；
* 或者
* 接口对象 对象名=new 实现类名称
*
*
* */
public class Demo01polymor {
    public static void main(String[] args) {
        //多态写法
        //父类引用指向子类对象

        Fu obj=new Zi();
        obj.method();
        obj.method1();

    }


}
