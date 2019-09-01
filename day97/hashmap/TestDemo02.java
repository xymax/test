package com.xy.map.hashmap;

import java.util.*;

public class TestDemo02 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"world");
        map.put(4,"!!!!!");

        //取得map的所有key值
        Set<Integer> set=map.keySet();



        //迭代输出
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
