package com.x.oj;
/*
*
* 输入两个整数m和n，从数列1,2,3……n中随意取几个数，使其和等于m，要求将所有的可能罗列出来
*
* */
import java.util.LinkedList;

public class TestDemo02 {
        // used as a stack to save the result
        private static LinkedList<Integer> list = new LinkedList<Integer>();

        public static void findSum(int sum, int n) {
            if (n < 1 || sum < 1)
                return;
            if (sum < n)
                n = sum;
            if (sum == n) {
                for (int i = 0; i < list.size(); i++)
                    System.out.print(list.get(i) + " ");
                System.out.print(sum);
                System.out.println();
            }

            list.addLast(n);
            findSum(sum - n, n - 1);
            list.removeLast();
            findSum(sum, n - 1);
        }

        public static void main(String[] args) {
            int sum = 10;
            int n = 8;
            findSum(sum, n);
        }
}
