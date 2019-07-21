package com.xy.hx.test;
/*
* 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
      都按先录入排列在前的规则处理。

   例示：
   jack      70
   peter     96
   Tom       70
   smith     67

   从高到低  成绩            
   peter     96    
   jack      70    
   Tom       70    
   smith     67    

   从低到高

   smith     67  

   Tom       70    
   jack      70    
   peter     96      

输入描述:
输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开

输出描述:
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

示例1
输入
3
0
fang 90
yang 50
ning 70
输出
fang 90
ning 70
yang 50
*
* */

import java.util.*;
public class TestDemo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int option = sc.nextInt();//排序方法
            List<Person> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Person(sc.next(),sc.nextInt()));
            }
            if(option == 0){//降序
                list.sort((o1,o2) -> o2.score-o1.score);
            }else if(option == 1){
                list.sort((o1,o2) -> o1.score-o2.score);
            }
            for(Person person :list ){
                System.out.println(person.name+" "+person.score);
            }
        }
    }
}
class Person{
    public String name;
    public int score;

    public Person(String name,int score) {
        this.name = name;
        this.score = score;
    }
}
