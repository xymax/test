package com.xy.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 题目描述
对N个长度最长可达到1000的数进行排序。

输入描述:
输入第一行为一个整数N，(1<=N<=100)。
接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
每个数都是一个正数，并且保证不包含前缀零。
输出描述:
可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行。
示例1

输入
复制

3
11111111111111111111111111111
2222222222222222222222222222222222
33333333
输出
复制

33333333
11111111111111111111111111111
2222222222222222222222222222222222
* */
public class TestDemo02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String[] str;
        while ((line = br.readLine())!= null) {
            int n = Integer.parseInt(line);
            str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = br.readLine();
            }
            paixu(n, str);

        }

    }
    public static void paixu(int n,String str[]){
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compare(str[i], str[j])) {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }

            }
        }
        for (int m = 0; m < n; m++) {
            System.out.println(str[m]);
        }

    }
    public static boolean compare(String s1,String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return true;
        }else if (len1 < len2) {
            return false;
        }else {
            if (s1.compareTo(s2) > 0) {
                return true;
            }
        }
        return false;
    }
}
