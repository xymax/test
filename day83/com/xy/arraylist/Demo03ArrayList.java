package com.xy.arraylist;

/*
* ArrayList常用方法
* （1）
* public boolean add<E e>向集合里面添加元素，参数的类型与泛型必须一致，
* 对于ArrayList的add方法来说，添加一定会成功，返回值可用可不用。但对于其他集合就不一定了。
* （2）
* public E get（int index） ；从集合中获取元素，参数是索引编号，返回值是对应位置的元素。
* （3）
* public E remove（int index）；从集合中删除元素，参数是索引编号，返回值是对应位置的元素。
* （4）
* public int size（） ：获取集合的尺寸长度，返回值就是集合中包含的元素。
*
*
* */


import java.util.ArrayList;

public class Demo03ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        //1.向集合中添加元素：add
        boolean success = list.add("李四");
        System.out.println(list);  //李四
        System.out.println("添加的动作是否成功"+success); //李四
        list.add("张三");
        list.add("王五");
        System.out.println(list);


        //从集合中获取元素  list.get,从索引0开始
        String s = list.get(2);
        System.out.println(s);

        //从集合中删除元素 list.remove。eg删除1号索引
        String remove = list.remove(1);
        System.out.println("已经将"+remove+"删除还剩下"+list);

        //获取集合的长度  list.size
        int size = list.size();
        System.out.println(size);


    }


}
