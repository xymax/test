package com.xy.Static;
/*
*一旦使用static修饰成员方法，就是静态方法，静态方法不属于对象而是属于类的。
*
* 如果没有使用static关键字，那么必须先创建对象，然后通过对象才能使用它。
*
* 重点：
* 若是使用了static关键字，不必创建对象，可以直接使用，类型名称进行调用。
* 静态变量：类名称.静态变量
* 静态方法：类名称.静态方法
*
*
* 注意事项
* 1.静态只能访问静态，不能访问非静态
* 2.静态方法不能用this，this代表当前对象。
*
*
* */
public class Demo02staticMethod {
    public static void main(String[] args) {
     //普通方法:先创建对象，才能通过对象来使用它。，才能使用没有静态关键字的方法

        MyClass obj=new MyClass();
        obj.method();

        //对于静态方法。推荐写法。不需要创建对象。
        MyClass.staticmethod();//类名称.静态方法

        //对于本类当中的静态方法，可以忽略类名称，
        myMythod();



    }
    public static void myMythod(){
        System.out.println("自己的方法");
    }


}
