package com.xy.hx.day01;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String > stack =new Stack<>();
        stack.push("java");
        stack.push("C++");
        stack.push("Python");
        System.out.println("栈的大小:"+stack.size());
        System.out.println("栈是否为空："+stack.empty());


    }
}
