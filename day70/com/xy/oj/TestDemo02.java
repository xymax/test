package com.xy.oj;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。
* 当然，老师有时候需要更新某位同学的成绩.
*
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子:
5
6
5
9
* */


/*
* 解题基本思路：
（1）设置两动态数组，分别存放学生的数目和操作的数目。
（2）动态数组存放学生成绩。
（3）根据字符执行查询或是更新操作。
*
* */
public class TestDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                        //设置存放学生数目和操作数目的数组

        do {
            //System.out.println("请输入学生数目和操作数目:");
            int[] data = new int[2];

            data[0] = sc.nextInt();
            data[1] = sc.nextInt();
            //System.out.println("请输入学生成绩:");
            ArrayList<Integer> array = new ArrayList<Integer>();        //将成绩存入动态数组中
            for (int i = 0; i < data[0]; i++) {
                array.add(sc.nextInt());
            }

            int time = 0;
            char a;
            int b, c;
            while (time < data[1]) {
                //  System.out.println("请输入操作命令:");
                a = sc.next().charAt(0);                                //获得一行字符
                b = sc.nextInt();
                c = sc.nextInt();

                if (a == 'Q') {
                    int start, end;
                    if (b < c) {
                        start = b - 1;
                        end = c - 1;
                    } else {
                        start = c - 1;
                        end = b - 1;
                    }

                    int max = array.get(start);             //获得第一个查询的学生成绩
                    for (int index = start + 1; index <= end; index++) {
                        if (max < array.get(index)) {
                            max = array.get(index);
                        }
                    }
                    System.out.println(+max);
                    max = 0;
                }

                if (a == 'U') {
                    int index1 = b - 1;
                    int newValue = c;
                    array.set(index1, newValue);
                }
                time++;
            }
        } while (sc.hasNext());
        sc.close();
    }

}
