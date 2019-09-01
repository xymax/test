package com.xy.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TestDemo01 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"world");
        map.put(4,"!!!!!");
        map.put(4,"hahaha");

        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.get(4));


        System.out.println(map.get(99));  //没有返回null






    }




}
