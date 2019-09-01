package com.xy.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestDemo04 {
    public static void main(String[] args) {
        Map<String ,Integer> map=new HashMap();
        map.put("张三",18);
        map.put("李四",20);
        map.put("王五",19);
        Set<String> strings = map.keySet();
        //遍历
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }


    }
}
