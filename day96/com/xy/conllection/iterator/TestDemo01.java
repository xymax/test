package com.xy.conllection.iterator;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDemo01 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!");

        //使用迭代器 遍历  每个集合对象都有自己的迭代器
        Iterator<String > it=list.iterator();

        while (it.hasNext()){  //判断是否有迭代元素
            String s=it.next();  //获取迭代元素
            System.out.println(s);
        }


    }
}
