package com.xy.hx.sort;


import java.util.Arrays;

/*
 * 选择排序
 *
 * */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        selectSort(arr, 7);
        System.out.println(Arrays.toString(arr));

    }


    public static void selectSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (array[i]>array[j]) {
                    int temp = 0;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

        }
    }
}
