package com.xy.string.method;
/*
*
* 1.对字符串内容进行比较，2个方法
*
* public boolean equals（Object obj） ：参数可以是任何对象，内容相同是true不然false
* public boolean equalsIgnoreCase（String str） 不区分大小写
* 注意：
* 任何对象都可以使用Object接收
* 具有对称性
*比较常量和变量时，推荐把常量写在前面（不然会报空指针异常）
*
*
*
* */
public class demo01 {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        char[] chars={'a','b','c'};
        String s3=new String(chars);
        System.out.println(s1.equals(s2)); //true
        System.out.println(s2.equals(s3));  //true
        System.out.println(s1.equals(s3));  //true
        System.out.println("abc".equals(s2)); //true

        System.out.println("ABC".equals(s2)); //false  区分大小写
        System.out.println("ABC".equalsIgnoreCase(s2));//true;  不区分大小写



    }
}
