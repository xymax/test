package com.xy.scanner;

import java.util.Scanner;

public class ScannerDemo02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int a=scanner.nextInt();
        System.out.println("请输入第二个数字");
        int b=scanner.nextInt();
        System.out.println("请输入第三个数字");
        int c=scanner.nextInt();

        int temp= Math.max(a, b);
        int max= Math.max(temp, c);
        System.out.println("最大值为"+max);


    }
}
