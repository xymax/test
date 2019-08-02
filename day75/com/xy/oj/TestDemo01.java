package com.xy.oj;

import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            keepShape(n);

        }
    }
    public static void keepShape(int n){
        int num1=n;
        int num2=n*n;
        if ((num2%1==num1)||(num2 % 10) == num1 || ((num2 % 100) == num1) || (num2 %1000==num1)){
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }
}
