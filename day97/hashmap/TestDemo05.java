package com.xy.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestDemo05 {
    public static void main(String[] args) {
        Map<String ,Integer> map=new HashMap();
        map.put("张三",18);
        map.put("李四",20);
        map.put("王五",19);
        Set<Map.Entry<String ,Integer>> set=map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key=entry.getKey();
            Integer value=entry.getValue();
            System.out.println(key+" ="+value);
        }

        System.out.println("=============");

        for (Map.Entry<String,Integer> entry: set){


        String key=entry.getKey();
        Integer value=entry.getValue();
        System.out.println(key+" ="+value);

        }
    }
}
