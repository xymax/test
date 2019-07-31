package com.xy.oj;
/*
* 题目描述：
输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。
输入
测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。
输出
对于每组输入,请输出结果。
样例输入
4
1 2 3 4
3
样例输出
2
* */
import java.util.Arrays;
import java.util.Scanner;

public class TestDemo01 {



    //方法一
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            System.out.println(sum(arr, x ));
        }
    }
//找到x的下标，找不到返回-1
    public static int sum(int[] arr, int x) {
        for (int i = 0; i <arr.length; i++) {
            if (x==arr[i]) {
                return i;
            }
        }
        return -1;
    }










    //方法二

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums = sc.nextLine().split(" ");
        String x = sc.nextLine();
        System.out.println(Arrays.asList(nums).indexOf(x));
    }


}
