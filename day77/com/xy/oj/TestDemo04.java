package com.xy.oj;

import java.util.Scanner;

/*
* 题目描述：
输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。

输入：
输入包括一个字符串，字符串长度不超过100。

输出：
可能有多组测试数据，对于每组数据，
对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。

样例输入：
3
3a
样例输出：
10110011
10110011
01100001

* */
public class TestDemo01 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int i, n;
        String temps, str, temp;
        str = new String("00000000");
        Integer result;
        while (cin.hasNextLine()) {
            temps = cin.nextLine();
            n = temps.length();
            for (i = 0; i < n; ++i) {
                result = (int) temps.charAt(i);
                if (Integer.bitCount(result) % 2 == 0) result += 128;
                temp = Integer.toBinaryString(result);
                System.out.print(str.substring(0, 8 - temp.length()));
                System.out.println(temp);
            }
        }
    }
}
