package com.xy.hx.sort;

import java.util.Arrays;

/*
* 归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，算法不是自适应的，不需要对数据的随机读取。

工作原理：

1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列

2、设定两个指针，最初位置分别为两个已经排序序列的起始位置

3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置

4、重复步骤3直到某一指针达到序列尾

5、将另一序列剩下的所有元素直接复制到合并序列尾
*
* */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("xxx");
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后" + Arrays.toString(arr));
    }

    //分+和的过程
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行索引
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    //合并的过程
    /*
     * arr:排序的原始数组
     * left：左边有序序列的初始索引
     * mid：中间索引
     * right：右边索引
     * temp：做中转的数组
     *
     *
     * */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引。
        int j = mid + 1;//初始化j，右边有序的初始索引
        int t = 0;//指向temp数组的当前索引
        //(1)先把左右两边（有序）的数据按规则填充到temp中去直到左右两边的有序序列，
        // 有一边处理完毕为止。
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边的有序序列的当前元素
            //将左边的当前元素拷贝到temp数组。
            //将索引后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {//反之将右边边的当前元素拷贝到temp数组。
                temp[t] = arr[j];
                t += 1;
                j++;
            }
        }
        //(2)把有剩余数据的一边依次填充到temp中去。
        while (i <= mid) {//左边的有序序列还有剩余元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//左边的有序序列还有剩余元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //(3)将temp数组的元素拷贝到arr
        //并不是每次都拷贝8个
        t = 0;
        int templeft = left;//
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }
    }
}
