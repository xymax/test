package com.xy.scanner;

import javax.crypto.spec.PSource;
import java.util.Scanner;

//导包
//创建对象
//获取从键盘输入的int数字
public class ScannerDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);//从键盘输入
        int num=scanner.nextInt();
        System.out.println("输入的数字是"+num);
        //next()是字符串。
        String s=scanner.next();
        System.out.println("输入的字符串是"+s);


    }
}
