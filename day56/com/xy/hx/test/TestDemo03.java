package com.xy.hx.test;

import java.util.Scanner;

public class TestDemo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();//输入一个整数
            /*
            * 将int整形转化为字符串一共有三种方法。
            * 1.第一种调用String的valueOF方法
            * 2.用Integer
            * 3.“”""+int整形
            * */
            String str = String.valueOf(n);    //方法一
            //  String str = Integer.toString(n);
            //String str =""+n;
            //将字符串倒叙输出
            StringBuilder sb = new StringBuilder(str);
            str = sb.reverse().toString();
            System.out.println(str);
        }
    }
}
