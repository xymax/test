package com.xy.Static;

public class MyClass {

    private int num;//成员变量
    static int numStatic; //静态变量



    //成员方法
    public void method(){
        System.out.println("成员方法");
        System.out.println(num);
        System.out.println(numStatic);
    }




    public static void staticmethod(){

        System.out.println("“这是静态方法");
        System.out.println(numStatic);



    }

}
