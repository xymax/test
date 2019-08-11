package com.xy.anonymity;

import com.sun.deploy.security.SandboxSecurity;

import java.util.Scanner;

public class Demo02Anonymoius {
    public static void main(String[] args) {
        //普通使用方式
   /*     Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();*/


        //匿名方式
        //      int num2 = new Scanner(System.in).nextInt();
        //    System.out.println("输入的是："+num2);



        //使用一般方式进行传参
       /* Scanner scanner=new Scanner(System.in);
        mothodParam(scanner);*/


        //使用匿名对象类进行传参。
        //mothodParam(new Scanner(System.in));


        Scanner sc = methodReturn();
        int i = sc.nextInt();
        System.out.println("输入的的是："+i);
    }

//
    public static void mothodParam(Scanner scanner) {
        int i = scanner.nextInt();
        System.out.println("输入的是"+i);
    }


    public static Scanner methodReturn(){
        //使用普通方法返回
/*        Scanner scanner=new Scanner(System.in);
        return scanner;*/

        //使用匿名方式返回

        return new Scanner(System.in);


    }
}
