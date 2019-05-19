package com.xy.day28;

public class TestMergeSort {

    public static void merge(int[] array, int start, int mid, int end) {
        //在另一个数组中归并。
        int[] tempArray = new int[array.length];
        int tempIndex = start;
        int start2 = mid + 1;
        //两个归并段都有数据
        int i=start;
        while (start <= mid && start2 <= end) {
            if (array[start] <= array[start2]) {
                tempArray[tempIndex++] = array[start++];
                start = start + 1;
            } else {
                tempArray[tempIndex++] = array[start2++];
            }
        }
        while (start <= mid) {
            tempArray[tempIndex++] = array[start++];
        }
        while (start2<=end){
            tempArray[tempIndex++] = array[start2++];
        }
        while (i<=end){
            array[i]=tempArray[i];
            i++;
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {//递归中止条件。
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);//分解
        //肯定是一个有序的序列。
        //递归左，递归右
        //合并的过程
        merge(array, start, mid, end);
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 95, 78, 165, 984, 1546, 1, 66, 55, 44, 88, 77, 88};
        mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
