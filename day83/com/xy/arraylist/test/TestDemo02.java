package com.xy.arraylist.test;

import java.util.ArrayList;

/*
题目
* 自定义4个学生对象，添加到集合并遍历。
思路：
*1.自定义Student类，
*2.创建一个集合，用来储存学生对象
*3.根据类，创建4个学生对象
*4.将学生4个对象添加到集合中，add
*5.遍历集合 for size get
*
*
* */
public class TestDemo02 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList=new ArrayList<>();

        Student one=new Student("张三",18);
        Student two=new Student("李四",19);
        Student three=new Student("王五",20);
        Student four=new Student("赵六",17);

        arrayList.add(one);
        arrayList.add(two);
        arrayList.add(three);
        arrayList.add(four);

        for (int i = 0; i < arrayList.size(); i++) {
            Student student=arrayList.get(i);


            System.out.println("姓名"+student.getName()+"年龄"+student.getAge());


        }




    }


}
