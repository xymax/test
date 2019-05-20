package com.xy.bit.day11;

public class TestDemo3 {
    public static void main(String[] args) {
        String str="HelloBit";
        String str2=new String("HelloBit");
        System.out.println(str==str2);
        String str3="HelloBit";
        System.out.println(str==str3);
        String str4="Hello"+"bit";
        System.out.println(str==str4);
        String str5="Hello";
        String str6=new String("bit");
        String str9=new String("terry").intern();//手动入池,
        String str10="terry";
        System.out.println(str9==str10);
    }
}