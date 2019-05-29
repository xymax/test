package com.biitech.jcf;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

/**
 * Author: secondriver
 * Created: 2019/5/29
 */
public class TestIterator {
    
    public static void code1(){
        Set<String> list = new HashSet<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        System.out.println(list);
    
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if ("Java".equals(element)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    
    
        //线程不安全
        //ConcurrentModificationException
//        for (String element : list) {
//            System.out.println(element);
//            list.remove(element);
//        }
    }
    
    public static void code2(){
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");

//        for (int i=list.size()-1; i>=0; i--){
//            System.out.println(list.get(i));
//        }
        ListIterator<String> iterator=list.listIterator();
        System.out.println("从前往后：");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" -> ");
        }
        System.out.println();
        System.out.println("从后往前：");
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous());
            System.out.print(" <- ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Vector<String> list = new Vector<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
    
        Enumeration<String> enumeration = list.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
