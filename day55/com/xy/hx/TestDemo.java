package com.xy.hx;

public class TestDemo {
    //父推子:左孩子2n+1有            右孩子：2n+2       子推父：(n-1)/2
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};
        TestHeap testHeap=new TestHeap();
        testHeap.initHeap(array);
        testHeap.show();
    }
}
