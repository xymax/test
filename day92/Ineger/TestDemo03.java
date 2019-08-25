package com.xy.Ineger;
/*
* 基本类型与字符串之间的相互转换
*
* 基本类型转化为字符串（string）
*  1.基本类型的值+""最简单的方法
*  2.包装类的静态方法toString（参数）方法  注意不是Object的toString
*  3.String类的静态方法valueOf
*
*
* 字符串转化为基本类型
*  1.使用包装类的pathXXX（数组类型的字符串）方法
*
* */
public class TestDemo03 {
    public static void main(String[] args) {
        //基本类型转化为字符串
        //方法1
        System.out.println("=========方法1============");
        int i1=100;
        String s=i1+"";
        System.out.println(s);
        //方法2
        System.out.println("=========方法2============");
        String s1 = Integer.toString(i1);
        System.out.println(s1);
        //方法3
        System.out.println("=========方法3============");
        String s2 = String.valueOf(i1);
        System.out.println(s2);


        System.out.println("=============转换=============");

        //字符串转化为基本类型
        int i = Integer.parseInt(s1);
        System.out.println(i);


    }




}
