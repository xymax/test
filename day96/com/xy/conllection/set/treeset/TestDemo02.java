package com.xy.conllection.set.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TestDemo02 {
    public static void main(String[] args) {
        Set<Penson> set=new TreeSet<>();
        set.add(new Penson(20,"张三"));
        set.add(new Penson(25,"李四"));
        set.add(new Penson(20,"张王五"));
        set.add(new Penson(18,"张三"));
        set.add(new Penson(260,"张三"));
        System.out.println(set);

    }
}
