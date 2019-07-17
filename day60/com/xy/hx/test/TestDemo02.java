package com.xy.hx.test;
/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

       //两个数的和可以分解为（两数异或）与（两数按位与左移一位）的和，这可以是迭代。
        //1. 两数异或  是将两个数中不同的二进制位直接相加的结果，
        //2. 两数按位与  则是得到进位的结果，
        //3. 进位左移一位和异或结果，重复1,2。
*
* */
public class TestDemo02 {

    public int addAB(int A, int B) {
        if (B == 0) {
            return A;
        }
        if (A == 0) {
            return B;
        }
        return addAB((A & B) << 1, A ^ B);
    }
}
