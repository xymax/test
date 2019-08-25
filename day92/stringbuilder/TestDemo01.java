package com.xy.stringbuilder;

public class TestDemo01 {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1=new StringBuilder("abc");
        System.out.println(stringBuilder1);
        StringBuilder d = stringBuilder1.append("d");
        System.out.println(d);
        StringBuilder abcd = stringBuilder.append("abcd");
        System.out.println(abcd);
        System.out.println(stringBuilder==abcd);  //对于引用类型比较的是地址  ，地址不会变化


    }

}
