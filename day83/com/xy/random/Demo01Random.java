package com.xy.random;


import java.util.Random;

/*
* Random产生随机数字的。
*
*
* 使用：
* 1.获取一个随机的int数字(范围是int所有范围) int r=random.nextint();
* 2.获取有个int数字（代表了参数范围） int r=random。nextint（5）
* 就会在（0到4取值）--》左闭右开
*
*
*
*
* */
public class Demo01Random {
    public static void main(String[] args) {
        Random r=new Random();
        int num = r.nextInt();

        System.out.println("随机数是："+num);
    }

}
