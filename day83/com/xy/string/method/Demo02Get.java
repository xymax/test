package com.xy.string.method;
/*
* 获取常用方法
*
* public int length（）； 返回此字符串的长度。
*
* public String concat(String str)  拼接字符串
*
* public char charAt(int index)返回指定索引处的 char 值。索引范围
* 为从 0 到 length() - 1。序列的第一个 char 值位于索引 0 处，
* 第二个位于索引 1 处，依此类推，这类似于数组索引。
*
* public int indexOf(String str)
* 返回指定子字符串在此字符串中第一次出现处的索引。若没有返回-1.
*
*
*
* */
public class Demo02Get {
    public static void main(String[] args) {
        //获取长度
        int length = "dhfaaskjfdjakjs".length();
        System.out.println(length);

        System.out.println("=====================");

        //拼接字符串 ,只要字符串改变就一定是创建了一个新的字符串
        String s1="hello";
        String s2="world";
        String s3=s1.concat(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("===========================");


        //获取索引位置的单个字符。
        char c = "hello".charAt(2);
        System.out.println(c);
        System.out.println("==================");


        //查找字符串在原来字符串出现的位置，没有返回-1.有多个只是找第一个。
        String s4="helloworld";
        int index = "ll".indexOf(s4);
        int i = "fdj".indexOf(s4);
        System.out.println(index);
        System.out.println(i);


    }
}
