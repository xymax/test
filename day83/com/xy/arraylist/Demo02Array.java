package com.xy.arraylist;

import java.util.ArrayList;

/*
* 与数组区别
* 答：数组的长度一般是不可以变化的，而ArrayList的长度是可以发生变化。
*
* 对于ArrayList<E>代表泛型：也就是装在集合中的所有元素，全部是同一的类型。
* 泛型只能是引用类型，不能是基本类型。
*
*
*
*
* */
public class Demo02Array {
    public static void main(String[] args) {
        //创建一个ArrayLi集合，集合的名称是List。里面全部是String类型
        //从jdk1.7开始右侧的尖括号可以不写内容
        ArrayList<String > list=new ArrayList<>();

      /*  对于ArrayList来说，直接打印不是地址值而是内容。
        如果内容为空，得到的是空的中括号。*/
        System.out.println(list); //   []
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list);
    }
}
