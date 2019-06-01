package com.xy.hx.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "java", "c++", "c", "python", "Go", "PHP", "VB",
                "C#", "E", "R", "perl", "javas", "CSS");
        //  list.forEach(s -> System.out.println(s));


//        System.out.println(list.size());
//        System.out.println(list.stream().count());

//        System.out.println(list.stream().filter(s -> s.contains("java")));

//        System.out.println(list.stream().map(s -> s.toLowerCase())
//                .filter(s -> s.contains("c"))
//                .filter(s -> s.length() > 2)
//                .collect(Collectors.toList()));

        System.out.println(list.stream().skip(2).limit(5));

    }
}
