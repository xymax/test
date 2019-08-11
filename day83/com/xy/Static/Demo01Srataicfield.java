package com.xy.Static;

/*
 * 若是一个成员变量使用了static关键字，这个变量就不在属于对象自己而是属于所在的类
 *
 *
 * */
public class Demo01Srataicfield {
    public static void main(String[] args) {
        Penson one = new Penson("张三", 18);
        Penson two = new Penson("李四", 19);
        Penson three = new Penson("王五", 17);
        one.room = "101教室";
        System.out.println("姓名：" + one.getName() + "，年龄：" + one.getAge()+"教室:"+one.room+"学号："+one.getId());
        System.out.println("姓名：" + two.getName() + "，年龄：" + two.getAge()+"教室:"+two.room+"学号："+two.getId());
        System.out.println("姓名：" + three.getName() + "，年龄：" + three.getAge()+"教室:"+three.room+"学号："+three.getId());
    }

}
