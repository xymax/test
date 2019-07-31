package com.xy.oj;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/*
* /*
* 题目描述：
对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。

输入：
每行输入数据包括一个正整数n(0<n<40000)，如果n=0 表示输入结束，并不用计算。

输出：
对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，输出在一行中，之间用一个空格分隔，但行末不要有空格。

样例输入：
4
12
97
39999
0
样例输出：
4 7
3 9
16 22
39 36
 */

public class TestDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(sum(n)+" "+squareSum(n));
        }
    }
    public static int sum(int num){
        int sum=0;
        while (num!=0) {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public static int squareSum(int num){
        int sum1=0;
        int s=num*num;
        while (s!=0){
            sum1+=s%10;
            s/=10;
        }
        return sum1;
    }
}
