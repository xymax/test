package com.xy.bit.day11;

public class TestDemo06 {
    public static void main3(String[] args) {

    }






















    public static void main(String[] args) {
        String string="Hello";
        String string2="hello";
        System.out.println(string.equals(string2));
        System.out.println(string.equalsIgnoreCase(string2));//忽略大小写
        System.out.println(string.compareTo(string2));//找到第一个不相同的字符进行比较，
        //如果长度不一样len1-len2
        System.out.println(string.contains("ll"));//判断一个连续的字符串是否存在
        System.out.println(string.indexOf("ll",3));//从3号下标开始找，找不到返回-1
        System.out.println(string.lastIndexOf("el"));
        System.out.println(string.startsWith("He"));//是否以He开头
        System.out.println(string.endsWith("l"));//是否以结尾
        System.out.println("========================");

    }













    public static void main1(String[] args) {
        byte[] bytes={97,98,99,100};
        String string=new String(bytes,1);
        System.out.println(string);
        byte[] bytes1=string.getBytes();
    }


}
