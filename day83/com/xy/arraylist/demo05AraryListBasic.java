package com.xy.arraylist;

import java.util.ArrayList;

//泛型只能是引用类型，不能是基本类型。
//  错误示范
//  ArrayList<int> arrayList=new ArrayList<>();


/*
* 如果希望向集合ArrayL当中存储基本类型，必须使用基本类型对应的“包装类”
* 基本类型      基本类型的包装类型
*   byte           Byte
*   short          Short
*   int            Integer  *
*   long           Long
*   float          Float
*   double         Double
*   char           Character  *
*   boolean        Boolean
*.
* 从jdk1.5开始，支持自动装箱，拆箱。
* 自动装箱：  从基本类型到包装类型
* 自动拆箱：  从包装类型到基本类型
*
*
*
*
* */

public class demo05AraryListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(200);
        System.out.println(arrayList);
        arrayList.add(100);
        arrayList.add(15);

        Integer integer = arrayList.get(2);
        System.out.println(integer);


    }

}
