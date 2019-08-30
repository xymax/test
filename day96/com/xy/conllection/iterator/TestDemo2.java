package com.xy.conllection.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("DEF");
        list.add("G");
        list.add("H");

        ListIterator<String> li=list.listIterator();

        System.out.print("从前往后输出");
        while (li.hasNext()){           //判断是否有下一个元素
            //取得下一个元素
            String next = li.next();
            System.out.print(next+",");
        }


        System.out.print("从后先前输出:");
        while (li.hasPrevious()){          //判断是否有前一个元素
            String previous=li.previous();
            System.out.print(previous+",");
        }




    }
}
