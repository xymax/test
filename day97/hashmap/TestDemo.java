package com.xy.map.hashmap;

import java.util.HashMap;
import java.util.Set;

public class TestDemo {
    public static void main(String[] args) {
        HashMap<String,Penson> map=new HashMap<>();
        map.put("北京",new Penson("张而",18));
        map.put("上海",new Penson("找三",19));
        map.put("南京",new Penson("李四三",25));
        map.put("北京",new Penson("张三",18));

        Set<String> set=map.keySet();
        for (String key:set ) {
            Penson penson = map.get(key);
            System.out.println(key+"="+penson);

        }
    }
}
