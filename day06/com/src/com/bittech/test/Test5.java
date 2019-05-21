package com.bittech.test;

import java.util.Scanner;

/**
 * Author: secondriver
 * Created: 2019/5/15
 */
public class Test5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt(); //学生数量
            m = scanner.nextInt(); //老师可以操作的次数
            int[] stu = new int[n];//学生成绩
            for (int i = 0; i < n; i++) {
                stu[i] = scanner.nextInt();
            }
            //老师询问
            for (int i = 0; scanner.hasNext() && i < m; i++) {
                String c = scanner.next();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (c.equals("Q")) {
                    int s = Math.min(a, b);//开始下标
                    int e = Math.max(a, b);//结束下标
                    int max = stu[s - 1];
                    //计算出 [s-1 , e)范围的最大值
                    for (int index = s; index < e; index++) {
                        max = Math.max(max, stu[index]);
                    }
                    System.out.println(max);
                }
                if (c.equals("U")) {
                    stu[a - 1] = b;
                }
            }
        }
    }
}
