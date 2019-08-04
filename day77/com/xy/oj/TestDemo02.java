package com.xy.oj;

import java.util.Scanner;

/*
*
* 1给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

输入描述:

输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。

输出描述:

输出所求的方案数

示例：

输入
5 15 5 5 10 2 3
输出
4

分析：

n表示给出的数组长度（由于键盘输入，为了方便计算，我们将创建长度为n+1的数组，
* 存入时下标从1开始，表示第几个），m表示要组成的数字，创建数组dp[n+1][m+1]，
* dp[i,j]表示前i个可以凑到j的个数，而用前i个数据组成0的方案只有一种，
* 用前0个数据组成j的方案不存在，dp[i][j]等于拿了这个数据和没拿这个数据的方案总和，
* 没拿时只需要看前i-1个数据组成j-p[i]的方案数,当遍历到的p[i] > j时，
* 也就说明这个数据大于要凑成的数据，只能选择不拿。*/
public class TestDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        long[][] dp = new long[n+1][m+1];//dp[i,j]表示前i个可以凑到j的个数
        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        //用前i个数据组成0的方案只有一种
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        //用前0个数据组成j的方案不存在
        for(int j=1; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                //等于拿了这个数据和没拿这个数据的方案总和，没拿时只需要看前i-1个数据组成j-p[i]的方案数
                if(p[i] <= j){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-p[i]];
                }else{//p[i]>j时只能选择不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}
