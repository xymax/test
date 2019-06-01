package com.xy.hx.day01;

import java.util.Map;
import java.util.TreeMap;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,String > map=new TreeMap<>();
        map.put(1,"java");
        map.put(3,"C++");
        map.put(2,"c");
        System.out.println(map);

    }
}
