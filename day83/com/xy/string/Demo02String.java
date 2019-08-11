package com.xy.string;
/*
*
* 1.字符串常量池
*
* 只有直接写“”才在常量池中，new的不在
*
* 对于基本类型来说，==是对数值的比较
* 对于引用类型来说，==是对地址值的比较。
*
*
*
*
*
*
*
*
*
*
*
*
*
* */
public class Demo02String {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        char[] chars={'a','b','c'};
        String s3=new String(chars);
        System.out.println(s1==s2); //true
        System.out.println(s1==s3); //false
        System.out.println(s2==s3); //false


    }
}
