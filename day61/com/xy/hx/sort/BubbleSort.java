package com.xy.hx.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
 * 看是否满足大小关系要求。
 * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复n 次，
 * 就完成了 n 个数据的排序工作。
 *
 *
 * *
 */
public class BubbleSort {


    //第一种写法；全部遍历
    public static void bubbleSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

        }
    }

    //方法2：定义一个flag判断是否已经有序。
    public static void bubbleSort1(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 1; j < n - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
                if (!flag) {
                    break;
                }

            }

        }

    }


    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7};
        bubbleSort1(arr, 4);
        System.out.println(Arrays.toString(arr));

    }


}
