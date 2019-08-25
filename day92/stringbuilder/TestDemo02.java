package com.xy.stringbuilder;


/*
*
* StringBuilder和String可以相互转换，调用toString方法可以将StringBuild转化为String
*
* */
public class TestDemo02 {
    public static void main(String[] args) {

        String s="Hello";
        System.out.println(s);


        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder);


        stringBuilder.append(",World");
        stringBuilder.append("!!!");

        System.out.println(stringBuilder.toString());


    }
}
