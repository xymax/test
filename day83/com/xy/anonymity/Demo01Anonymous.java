package com.xy.anonymity;

//没有名字的对象就是匿名对象

//类名称 对象名=new 类名称


//匿名对象就是只是右边的对象，没有左边的名称和赋值运算符。
//匿名对象只能使用唯一的一次，下次使用就必须创建一个新对象。
//使用方式：如果确定一个对象只使用一次，就可以使用匿名对象。

public class Demo01Anonymous {
    public static void main(String[] args) {
        //1.不是匿名对象，左边的one就是对象的名字
        Penson one = new Penson();
        one.name = "李四";
        one.showName();

        System.out.println("===============================");


         //2.匿名对象(没有名字)
        new Penson().name="张三";
        new Penson().showName();  //?  null




    }
}
