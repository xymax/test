package com.xy.hx;

import java.util.Scanner;

/*
* 题目描述：

输入n个整数，输出出现次数大于等于数组长度一半的数。
输入描述:
每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
输出描述:
输出出现次数大于等于n/2的数。
示例1
输入

3 9 3 2 5 6 7 3 2 3 3 3
输出

3
* */
public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        int i = 0;

        while (sc.hasNext()) {
            a[i] = sc.nextInt();
            i++;
        }
        int count = 0;
        int num = a[0];
        for (int j = 0; j < i; j++) {
            if (a[j] == num) count++;
            else if (count > 0) count--;
            else num = a[j];
        }
        System.out.println(num);
    }
}

