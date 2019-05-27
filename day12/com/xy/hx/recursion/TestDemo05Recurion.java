package com.xy.hx.recursion;

import java.io.File;

public class TestDemo05Recurion {
    public static void main(String[] args) {
        File file=new File("D:\\test");
        getAllFile(file);
    }
    public static void getAllFile(File dir){
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                getAllFile(f);
            }else {
                //只要.java结尾的文件
                //1.把File对象f,转为字符串对象

                //String name = f.getName();//hello.java
                //String path = f.getPath();//D:\\test\\hello.java
/*                String s = f.toString();//D:\\test\\hello.java
                System.out.println(f);

                //2.调用String类中的方法endsWith判断字符串是否以java结尾。
                boolean b = s.endsWith(".java");
                //3.如果是以。java结尾的文件，则输出。
                if (b){
                    System.out.println(f);*/
                if (f.getName().toLowerCase().endsWith(".java"));
                }
            }
        }
    }




