package com.xy.hx.test;

import java.util.Arrays;
import java.util.Scanner;

/*
* 问题：找出n个整数里最小的k个数
* */
public class TestDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String[] arr = scanner.nextLine().trim().split(" ");
            int[] num = new int[Integer.parseInt(arr[arr.length-1])];
            for(int i=0; i<num.length; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(num);
            for(int i=num.length; i<arr.length-1; i++) {
                int temp = Integer.parseInt(arr[i]);
                if(temp < num[num.length-1]) {
                    int j=num.length-2;
                    for(; j>=0 && temp<num[j]; j--) {
                        num[j+1] = num[j];
                    }
                    num[j+1] = temp;
                }
            }
            for(int i=0; i<num.length-1; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println(num[num.length-1]);
        }
        scanner.close();
    }

}
