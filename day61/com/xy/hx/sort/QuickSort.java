package com.xy.hx.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int left, int right) {
        int key = array[left];
        int start = left;
        int end = right;
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] < key) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = key;
        if (start > left) {
            quickSort(array, left, start - 1);
        }
        if (end < right) {
            quickSort(array, end + 1, right);
        }
    }


}
