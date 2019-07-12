package com.bittech.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 19:03
 * @Description:
 */
// 成员内部类能否拥有静态变量?能否访问外部类的静态变量
// 静态内部类能否拥有成员变量?能否访问外部类的普通属性
public class FinalTest {
    private int i = 0;
    private static int y = 0;
    private class InnerClass {

    }
    private void test() {
        System.out.println(i);
        System.out.println(y);
    }
    public static void main(String[] args) {

    }
}
