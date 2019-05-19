package com.xy.day28;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

//快速排序
public class TestFastSort {
    public static int partion(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if (low >= high) {
                break;
            } else {
                array[low] = array[high];
            }
            while ((low < high) && array[low] <= tmp) {
                low++;
            }
            if (low >= high) {
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

    public static void insertSort1(int[] array,
                                   int start, int end) {
        int tmp = 0;
        //5   21
        for (int i = start + 1; i <= end; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i - 1; j >= start; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    public static void swap(int[] array, int start, int end) {

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

    }

    public static void medianOfThree(int[] array, int low, int high) {
        int mid = (low + high) >> 1;
        if (array[mid] > array[high]) {
            swap(array, array[mid], array[high]);
        }
        if (array[low] > array[high]) {
            swap(array, array[low], array[high]);
        }
        if (array[mid] > array[low]) {
            swap(array, array[mid], array[low]);
        }
    }


    public static void quick(int[] array, int start, int end) {
        //1 2 3 4 5
        if (end - start + 1 <= 16) {
            insertSort1(array, start, end);
            return;
        }
        int par = partion(array, start, end);
        //找左边是否有两个数据以上
        if (par > start + 1) {
            quick(array, start, par - 1);
        }
        //右边是否有两个数据以上
        if (par < end - 1) {
            quick(array, par + 1, end);
        }
    }


    //快排的非递归写法,使用栈。
    public static void quickSort(int[] array) {
        int[] stack = new int[array.length * 2];
        int top=0;
        int low=0;
        int high=array.length-1;
        //先进行一趟快速排序
        int par=partion(array,high,low);;
        //判断当前par的左右两边是否为两个以上
        if (par>low+1){
            stack[top++]=low;
            stack[top++]=par-1;
        }
        if (par<high-1){
            stack[top++]=par+1;
            stack[top++]=high;
        }
        //以上代码执行完毕，两边的数已经全部入栈
        //接下来需要判断栈是否为空，不为空，取出两个数进行partion
        while (top>0){
            high=stack[--top];
            low=stack[--top];
            par=partion(array,high,low);
            if (par>low+1){
                stack[top++]=low;
                stack[top++]=par-1;
            }
            if (par<high-1){
                stack[top++]=par+1;
                stack[top++]=high;
        }
    }


























    //快速排序
    public static void quickSort1(int[] array, int low, int high) {
        quick(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 95, 78, 88, 165,
                984, 1546, 1, 66, 55, 44, 88, 77, 69, 88};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }
}
