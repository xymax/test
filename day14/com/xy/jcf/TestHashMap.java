package com.biitech.jcf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: secondriver
 * Created: 2019/5/29
 */
public class TestHashMap {
    
    public static void main(String[] args) {
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C");
        map.put(3, "Python");
        map.put(4, "C++");
        map.put(5, null);
        map.put(6, "Python");
        map.put(1, "PHP");
        map.put(null, "SQL");//8
    
        /*
          HashMap
          1. key 可以为null
          2. key 不能重复
          3. value 可以为null
          4. value 可以重复
         */
        System.out.println(map);
        System.out.println("集合元素的个数：" + map.size());
        System.out.println("集合元素的所有key：" + map.keySet());
        System.out.println("集合元素的所有value：" + map.values());
        System.out.println("集合是否为空：" + map.isEmpty());
        System.out.println("获取key=null的value：" + map.get(null));
        System.out.println("获取key=4的value：" + map.get(4));
        System.out.println("获取key=9的value：" + map.get(9));
        System.out.println("集合是否包含key=12：" + map.containsKey(12));
        
        //遍历map
        //1. keySet 2. key -> value
        for (Integer key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        //2. value
        for (String value : map.values()) {
            System.out.println(value);
        }
        //3. entrySet
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry : set) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
    
}
