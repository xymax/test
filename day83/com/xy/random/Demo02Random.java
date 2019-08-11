package com.xy.random;

import javax.swing.*;
import java.util.Random;

/*
* * 2.获取有个int数字（代表了参数范围） int r=random。nextint（5）
 * 就会在（0到4取值）--》左闭右开
* */
public class Demo02Random {
    public static void main(String[] args) {
        Random random=new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(6);
            System.out.println("产生的随机数字是："+num);

        }




    }

}
