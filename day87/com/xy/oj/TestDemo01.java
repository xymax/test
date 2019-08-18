package com.xy.oj;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args) throws ParseException {
        int year;
        int mouth;
        int day;
        int e;     //用于循环
        Scanner scanner = new Scanner(System.in);
        do {                                           //使用do~while()可以在do语句中进行初始化
            e=0;                                       //while语句的话，必须手动初始化，因为局部变量初始化必须手动赋值
            System.out.println("输入年:");
            year = scanner.nextInt();
            System.out.println("输入月:");
            mouth = scanner.nextInt();
            System.out.println("输入日:");
            day = scanner.nextInt();
            if (mouth < 0 || mouth > 12 || day < 0 || day > 31) {
                System.out.println("输入格式错误，请重新输入！！！");
                e = 1;
            }
        } while (e == 1);
        Date date1 = new Date(year, mouth-1, day+1);           //月份从零开始，天数从一开始
        Date date2 = new Date(year, 0, 1);                     //所以，真正的月份要减一，天数加一才是真正的结果
        long l1 = date1.getTime();
        long l2 = date2.getTime();
        //天数
        int days =(int)((l1-l2)/(24*3600*1000));               //一天=24*60*60*1000(mill)

        System.out.println("这是"+year+"年的第"+days+"天");
    }

}
