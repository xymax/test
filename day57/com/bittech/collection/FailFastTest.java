package com.bittech.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yuisama
 * @Date: 2019-07-08 21:14
 * @Description:
 */
public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 1
        list.add("hello");
        // 2
        list.add("bit");
        // 3
        list.add("hello");
        // 4
        list.add("Java");
        // 迭代器模式
        // expectedModCount = modCount = 4
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // thr fail-fast
            String str = iterator.next();
            if (str.equals("bit")) {
                // 修改了list结构
                // modCount = 5
                list.remove("bit");
            }
            System.out.println(str);
        }
    }
}
