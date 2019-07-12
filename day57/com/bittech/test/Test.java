package com.bittech.test;

/**
 * @Author: yuisama
 * @Date: 2019-07-02 18:52
 * @Description:
 * A.6 B.610 C.null D.10
 */
public class Test {
    private String str = "6";
    private Integer age = 10;
    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str);
        test.changeTest(test);
        System.out.println(test.str);
        System.out.println(test.age);
    }
    // 值传递?
    private void change(String str) {
        str += "10";
    }
    private void changeTest(Test test) {
        test.age = 20;
    }
}
