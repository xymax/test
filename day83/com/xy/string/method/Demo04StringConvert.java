package com.xy.string.method;

/*

String当中与转换相关的常用方法有
public char[] toCharArray () ：将此字符串转换为新的字符数组。
public byte[] getBytes () ：使用平台的默认字符集将该
String编码转换为新的字节数组。
public String replace (CharSequence target, CharSequence replacement)
：将与target匹配的字符串使用replacement字符串替换。




* */
public class Demo04StringConvert {
    public static void main(String[] args) {
        String s1 = "hello";
        //转化字符数组
        char[] chars = s1.toCharArray();
        System.out.println(chars[2]);
        System.out.println("====================");

        //转化字节数组

        byte[] bytes = s1.getBytes();
        System.out.println(bytes[0]);

        System.out.println("=============");


        //替换
        String s2="how do you do";
        String replace = s2.replace("how", "How");//字符串变化，要从新给个。
        System.out.println(replace);

    }
}

