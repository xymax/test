package com.xy.day28;

public class TestHeapSort {
    //*堆排序
    //一次调整为大根堆的时间复杂度是多少。
    //一次调整的时间复杂度是多少？
    public static void adjust(int[] array, int start, int end) {
        int temp = array[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && array[i] < array[i + 1]) {
                i++;

            }
            if (array[i] > temp) {
                array[start] = array[i];
                start = i;
            } else {
                break;
            }
            array[start] = temp;
        }


  /*      int tmp = array[start];
        for (int i = 2 * start + 1; i <= end; i = i * 2 + 1) {
            //1、找到左右孩子的最大值的下标 i
            if ((i < end) && array[i] < array[i + 1]) {
                i++;//左右孩子里面的最大值下标
            }
            if (array[i] > tmp) {
                array[start] = array[i];
                start = i;
            } else if (array[i] < tmp) {
                break;
            }
        }
        array[start] = tmp;*/
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {//n/2
            adjust(array, i, array.length - 1);//log2n
        }
        //整棵树调整为大根堆的时间复杂度？nlog2n
        //交换
        for (int j = 0; j < array.length - 1; j++) {
            int tmp = array[array.length - 1 - j];
            array[array.length - 1 - j] = array[0];
            array[0] = tmp;
            //array.length-1-j  -1:上面已经交换说明有序了
            //调整的时候，不需要调整有序的数据。
            adjust(array, 0, array.length - 1 - j - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 95, 78, 88, 165, 984, 1546, 1, 66, 55, 44, 88, 14, 77, 88};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
