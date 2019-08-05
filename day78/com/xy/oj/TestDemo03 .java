package com.xy.oj;

import java.util.Scanner;

/*
* 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。

输入格式：

输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]区间内的整数，Sickle是[0, 17)区间内的整数，Knut是[0, 29)区间内的整数。

输出格式：

在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
输入样例1：

10.16.27 14.1.28

输出样例1：

3.2.1

输入样例2：

14.1.28 10.16.27

输出样例2：

-3.2.1
* */
public class TestDemo01 {
    public static void findMoney(String p, String a)
    {
        //两个常亮用来表示各个单位到最小单位之间的进制关系
        final int FIRST = 17*29;
        final int SECOND = 29;

        String[] ps = p.split("\\.");
        int l1 = ps.length;
        int moneyP = (l1>=1?Integer.parseInt(ps[0])*FIRST:0) +
                (l1>=2?Integer.parseInt(ps[1])*SECOND:0) +
                (l1>=3?Integer.parseInt(ps[2]):0); //5421

        String[] as = a.split("\\.");
        int l2 = as.length;
        int moneyA =  (l2>=1?Integer.parseInt(as[0])*FIRST:0) +
                (l2>=2?Integer.parseInt(as[1])*SECOND:0) +
                (l2>=3?Integer.parseInt(as[2]):0); //
        //找的钱数
        int find = moneyA - moneyP;
        if (find < 0)//如果是负数，在最前面先输出一个负号，然后把它当正数处理
        {
            find *= (-1);
            System.out.print("-");
        }
        System.out.println(find/(FIRST)+"."+(find%FIRST)/SECOND+"."+find%FIRST%SECOND);
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext())
        {
            String p = s.next();
            String a = s.next();
            findMoney(p, a);
        }
    }


}
