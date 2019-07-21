package com.xy.hx.test;


/*
* //一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
//给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
//
//知识点   字符串
//运行时间限制    10M
//内存限制  128
//输入
//输入一个string型基因序列，和int型子串的长度
//输出
//找出GC比例最高的字串
//样例输入  AACTGTGCACGACCTGA 5
//样例输出  GCACG
*
*
* */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();
        int n = sc.nextInt();
        sc.close();

        int max = 0;
        String result = null;
        for(int i = 0; i < input.length()-5; i++){
            //每次截取制定长度的字串进行遍历
            String temp = input.substring(i, i+n);
            int length = 0;
            for(int j = 0; j < n; j++){
                if(temp.charAt(j) == 'G' || temp.charAt(j) == 'C')
                    length++;
            }
            if(max < length){
                max = length;
                result = temp;
            }
        }
        System.out.println(result);
    }

}

