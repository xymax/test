package com.xy.hx.test;
/*
* 问题：N的阶乘(N!)中的末尾有多少个0?
例如:
N = 5,N! = 120.末尾有1个0.
N = 10，N! = 3628800.末尾有2个0。
* */

import java.util.Scanner;

public class TestDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();//输入一个整数；
            System.out.println(CountZero(n));
        }
    }


    public static int CountZero(int n)
    {
        int ret =0;
        while(n>0){
            ret=ret+n/5;
            n=n/5;
        }
        return ret;
    }
}
