package com.xy.oj;

import java.util.Scanner;

/*
*
* 1、对输入的字符串进行加解密，并输出。
2加密方法为：
当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
其他字符不做变化。
3、解密方法为加密的逆过程。
 
接口描述：
    实现接口，每个接口实现1个基本操作：
void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
说明：
1、字符串以\0结尾。
2、字符串最长100个字符。
 
int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
说明：
1、字符串以\0结尾。
2、字符串最长100个字符。


* */
public class TestDemo0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            mima(str1);
            unmima(str2);

        }
    }

    public static void mima(String str) {
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z')
                    System.out.print('A');
                else
                    System.out.print((char) (Character.toUpperCase(c) + 1));
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z')
                    System.out.print('a');
                else
                    System.out.print((char) (Character.toLowerCase(c) + 1));
            } else if (c >= '0' && c <= '9') {
                if (c == '9')
                    System.out.print('0');
                else
                    System.out.print((char) (c + 1));
            }
        }
        System.out.println();
    }

    public static void unmima(String str) {
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a')
                    System.out.print('Z');
                else
                    System.out.print((char) (Character.toUpperCase(c) - 1));
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A')
                    System.out.print('z');
                else
                    System.out.print((char) (Character.toLowerCase(c) - 1));
            } else if (c >= '0' && c <= '9') {
                if (c == '0')
                    System.out.print('9');
                else
                    System.out.print((char) (c - 1));
            }
        }
        System.out.println();
    }


}
