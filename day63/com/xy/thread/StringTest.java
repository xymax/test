package com.bittech.thread;

/**
 * @Author: yuisama
 * @Date: 2019-07-04 18:41
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        // 复用常量池
        String str1 = "abc";
        // 复用常量池
        String str2 = "ab";
        // 复用常量池
        String str3 = "c";
        // 字符串变量的拼接,javc->StringBuilder
        // StringBuilder sb  sb.append(str2).append(str3)
        // sb.toString()
        String str4 = str2 + str3;
        String str5 = "ab" + "c";
        String str6 = str2 + str3;
        String str7 = "ab" + str3;
        System.out.println(str1 == str7);
        System.out.println(str4 == str7);
    }
}
