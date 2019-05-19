package com.xy.day28;

public class TestInsertSort {
    //直接插入排序，越有序越快。
    public static void insertSort(int[] array) {
/*        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    //array[j+1]=temp;可要可不要。
                    break;
                }
            }
            array[j + 1] = temp;
        }*/


        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 95, 78, 88, 165, 984, 1546, 1, 66, 55, 44, 88, 77, 88};
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }
}
