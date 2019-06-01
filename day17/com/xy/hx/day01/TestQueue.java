package com.xy.hx.day01;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        queue.add("java");
        queue.add("C++");
        queue.add("C");
        queue.add("python");


        System.out.println("队列是否为空："+queue.isEmpty());
        System.out.println("队列个数："+queue.size());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("队列是否为空："+queue.isEmpty());
    }
}
