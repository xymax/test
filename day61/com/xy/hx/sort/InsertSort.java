package com.xy.hx.sort;

import java.util.Arrays;

/*
*
* 直接插入排序。
* */
public class InsertSort {
    public static void main(String[] args) {
        int[] array={9,5,2,7,3,6,8};
        insertSort(array,7);
        System.out.println(Arrays.toString(array));

    }
    public static void insertSort(int[] array,int n){
        int i,j,temp;
        for (i=1;i<n;i++){
            temp=array[i];
            for (j=i-1;j>=0;j--){
                if (array[j]>temp){
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            array[j+1]=temp;
        }
    }
}
