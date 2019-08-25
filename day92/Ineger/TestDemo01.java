package com.xy.Ineger;

import java.util.ArrayList;
import java.util.List;

public class TestDemo01 {
    public static void main(String[] args) {
        /*
        * 自动装箱：直接将int类型的整数赋值给包装类
        * */

        Integer s=11;

        List<Integer> list=new ArrayList<>();
        list.add(1);  //自动装箱

        Integer i = list.get(0); //自定拆箱 intValue

        System.out.println(i);

    }
}
