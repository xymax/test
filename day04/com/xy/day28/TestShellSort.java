package com.xy.day28;

public class TestShellSort {
    //希尔排序
    public static void shell(int[] array, int gap) {
        int temp = 0;
        for (int i = gap; i < array.length; i++) {
            int j = 0;
             temp=array[i];
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > temp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = temp;
        }

      /*  int tmp = 0;
        for (int i = gap; i < array.length; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }*/
    }

    public static void shellSort(int[] array) {
        int[] array2 = {5, 3, 1};
        for (int i = 0; i < array2.length; i++) {
            shell(array, i);

        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 95, 78, 88, 165, 984, 1546, 1, 66, 55, 44, 88, 77, 88, 15};
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
