package com.bittech.test;

import java.util.Scanner;

/**
 * Author: secondriver
 * Created: 2019/5/15
 */
public class Test4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String value = sc.nextLine();
            char[] chars = value.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ('A' <= c) {
                    //密码字母：A B C D E   F G H I J K L M N O P Q R S T U V W X Y Z
                    //原文字母：V W X Y Z   A B C D E F G H I J K L M N O P Q R S T U
                    //比如: F -> A  => F - 5
                    //比如：B -> W  => B + 21
                    c = (char) ('E' < c ? (c - 5) : (c + 21));
                }
                chars[i] = c;
            }
            System.out.println(new String(chars));
            
        }
    }
}
