package com.xy.oj;

import java.util.Scanner;

/*
* 题目描述：
北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
公式如下：
实际成绩 绩点
90——100 4.0
85——89 3.7
82——84 3.3
78——81 3.0
75——77 2.7
72——74 2.3
68——71 2.0
64——67 1.5
60——63 1.0
60以下 0
1．一门课程的学分绩点=该课绩点*该课学分
2．总评绩点=所有学科绩点之和/所有课程学分之和
现要求你编写程序求出某人A的总评绩点（GPA）。

输入：
第一行 总的课程数n（n<10）；
第二行 相应课程的学分（两个学分间用空格隔开）；
第三行 对应课程的实际得分；
此处输入的所有数字均为整数。

输出：
输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）

样例输入：
5
4 3 4 2 3
91 88 72 69 56
样例输出：
2.52
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int gradePoint[] = new int[n];//每门课学分
            int coursePoint[] = new int[n];//每门课分数
            for (int i = 0; i < n; i++) {
                gradePoint[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                coursePoint[i] = scanner.nextInt();
            }
            System.out.printf("%.2f", gpaAverage(gradePoint, coursePoint));
        }
    }

    public static double gpa(int grade) {
        if (grade >= 90 && grade <= 100) {
            return 4.0;
        } else if (grade >= 85 && grade <= 89) {
            return 3.7;
        } else if (grade >= 82 && grade <= 84) {
            return 3.3;
        } else if (grade >= 78 && grade <= 81) {
            return 3.0;
        } else if (grade >= 75 && grade <= 77) {
            return 2.7;
        } else if (grade >= 72 && grade <= 74) {
            return 2.3;
        } else if (grade >= 68 && grade <= 71) {
            return 2.0;
        } else if (grade >= 64 && grade <= 67) {
            return 1.5;
        } else if (grade >= 60 && grade <= 63) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public static double gpaAverage(int[] gradePoint, int[] coursePoint) {
        double gradePointTotal = 0;
        double greadpointsum = 0;
        for (int i = 0; i < coursePoint.length; i++) {
            gradePointTotal+= gpa(coursePoint[i]) * gradePoint[i];
            greadpointsum += gradePoint[i];

        }
        return  gradePointTotal / greadpointsum;

    }
}
