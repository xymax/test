package com.xy.arraylist;

import java.util.ArrayList;

public class Demo04Array {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("张三");
        list.add("王五");

        //遍历集合

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }
    }
}
