package com.xy.day28;

import java.lang.reflect.Array;
import java.util.Random;

public class TestSelsctSort {
    //选择排序
    public static void selsctSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp = 0;
                if (array[j] < array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100)+1;
            selsctSort(array);
            System.out.print(array[i] + " ");
        }

    }
}
