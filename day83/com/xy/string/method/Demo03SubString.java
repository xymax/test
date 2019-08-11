package com.xy.string.method;
/*
* 字符串的截取方法2种
*
* public String substring（int index） 截取从参数位置到末尾
* public String substring（int begin，int end） 截取从begin到end
* 左闭右开
*
*
*
* */
public class Demo03SubString {

    public static void main(String[] args) {
        String s1="helloworld";
        String substring = s1.substring(3);
        System.out.println(substring);

        String substring1 = s1.substring(2, 5);
        System.out.println(substring1); //左闭右开

    }
}
