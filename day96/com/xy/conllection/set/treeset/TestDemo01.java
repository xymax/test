package com.xy.conllection.set.treeset;

import java.util.Set;
import java.util.TreeSet;
/*
*
* 对于TreeSet来说就算放进去的元素不是有序的也会变成有序的元素
* TreeSet使用的是升序排列的模式完成的
*
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        Set<String> set=new TreeSet<>();

        set.add("A");
        set.add("B");
        set.add("D");
        set.add("C");
        System.out.println(set);


    }
}
