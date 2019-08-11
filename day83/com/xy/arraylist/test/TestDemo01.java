package com.xy.arraylist.test;

/*
 * 产生6个1-33随机数，添加到集合，并且遍历集合
 *
 *
 * 思路：
 * 1.需要存储6个数字。创建一个集合<Integer>
 * 2.产生随机数用Random
 * 3.用循环6次产生6个随机数字
 * 4.循环内调用r.nextInt（int n）
 * */

import java.util.ArrayList;
import java.util.Random;

public class TestDemo01 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int x = random.nextInt(33) + 1;
            arrayList.add(x);
        }
        for (int i = 0; i < 7; i++) {
            int size = arrayList.get(i);
            System.out.println(size);

        }


    }
}
