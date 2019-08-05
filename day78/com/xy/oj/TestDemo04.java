package com.xy.oj;

import java.util.*;

/*
* 给定一个正整数n,请返回0到n中2出现的次数
* */
//方法1
public class TestDemo02 {
    public static int countNumberOf2s(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += count(i);
        }
        return s;
    }

    public static int count(int i) {
        int count = 0;
        while (i != 0) {
            int num = i % 10;
            if (num == 2) {
                count++;
            }
            i = i / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2(25611511));
    }



    //方法2
        public static int countNumberOf2(int n) {
            int result = 0;
            for (int i = 1; i <= n; i *= 10) {
                result += (n / i + 7) / 10 * i + (n / i % 10 == 2 ? n % i + 1 : 0);
            }
            return result;
        }
}
