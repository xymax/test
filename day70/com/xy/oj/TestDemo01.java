package com.xy.oj;

import java.util.Scanner;

/*
* 题目：小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为a.
* 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
* 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并
且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.
* 那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
输入描述：
对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
输出描述：
对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值
示例1:
输入
3 50
50 105 200
5 20
30 20 15 40 100
输出
110
205

分析：每次比较当前武力值和当前怪兽武力值，大于就直接增加武力值，否则增加二者的最大公约数
* */
public class TestDemo01 {
    public static void main(String[] args) {
        // 对于每组数据,第一行是两个整数n(1≤n<100000)
        // 表示怪物的数量和a表示小易的初始能力值.
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            // 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
                System.out.println(power(n, a, b));
            }
        }
    }

    public static int power(int n, int a, int[] b) {
        for (int i = 0; i < n; i++) {
            //判断小明能力值能否打过怪物
            if (a >= b[i]) {
                a += b[i];
            } else {
                a += maxCommonNum(b[i], a);
            }
        }

        return a;
    }

    public static int maxCommonNum(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0){// 若余数为0,返回最大公约数
            return n;
        }
        else { // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonNum(n, m % n);
        }

    }

}
