package com.biitech.jcf;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/5/29
 */
public class TestLinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add(0,"PHP");
        list.add("C#");
        list.add("JavaScript");
        list.remove("C#");
        System.out.println(list);
    }
}
