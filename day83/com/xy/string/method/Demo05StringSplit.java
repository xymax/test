package com.xy.string.method;
/*
*
* public String[] split(String regex)
* ：将此字符串按照给定的regex（规则）拆分为字符串数组
* 他的参数是正则表达式。若是按英文"."来切分必须用“\\.“其他不用。
*
*
* */
public class Demo05StringSplit {
    public static void main(String[] args) {
        String s1="aaa,bbb,ccc";
        String[] array = s1.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("============");
        String s2="aaa.bbb.ccc";
        String[] array2 = s1.split("\\.");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
