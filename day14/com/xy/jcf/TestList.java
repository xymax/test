package com.biitech.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/5/28
 */
public class TestList {
    
    public static void code1() {
        Collection<String> list = new ArrayList<>();
        list.add("Java");
//        list.add(0, "C++");
        list.add("PHP");
        list.add("PHP");
//        System.out.println(list);
//        System.out.println(list.get(4));
//        System.out.println(list.get(3));
//        System.out.println("元素列表："+list);
//        System.out.println("集合长度："+list.size());
//        System.out.println("集合是否为空："+list.isEmpty());
//        System.out.println("集合是否包含PHP："+list.contains("PHP"));
//        System.out.println("集合是否包含CSS："+list.contains("CSS"));
//        System.out.println("移除集合中PHP："+list.remove("PHP"));
//        System.out.println(list);

//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//        for (String item : list) {
//            System.out.println(item);
//        }
        
        Object[] objects = list.toArray();
//        for (Object object : objects){
//            System.out.println(object);
//        }
//        System.out.println(objects);
        System.out.println(Arrays.toString(objects));
    }
    
    //Collection -> List -> ArrayList
    public static void main(String[] args) {
        Person2 person1 = new Person2();
        person1.setName("Jack");
        Person2 person2 = new Person2();
        person2.setName("Tom");
        List<Person2> person2s = new ArrayList<>();
        person2s.add(person1);
        person2s.add(person2);
    
        System.out.println(person2s);
        
        Person2 person3 = new Person2();
        person3.setName("Tom");
       
        
        
        System.out.println("是否包含Person3:"+person2s.contains(person3));
        System.out.println("是否包含Person2:"+person2s.contains(person2));
    }
}
