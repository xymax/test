package com.xy.random;

import java.util.Random;

/** 根据一个变量n的值来随机获取数字，范围是[1-n].
* */
public class Demo03Random {
    public static void main(String[] args) {
        Random random=new Random();
        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(5) + 1;
            System.out.println("产生的随机数字是"+num);
        }


    }
}
