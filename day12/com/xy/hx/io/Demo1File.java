package com.xy.hx.io;

/*
 * java.io.File类
 * java将电脑中文件和文件夹封装成一个File类。
 *1.可以使用的File方法；
 *   创建一个文件/文件夹
 *   删除文件/文件夹
 *   获取文件/文件夹
 *   判断文件/文件夹
 *   对文件夹进行遍历
 *   获取文件的大小
 * 2.File类是与系统无关的类，任何系统都可以使用。
 *
 * file ：文件   directory：文件夹，目录  path：路径
 * */

import java.io.File;

public class Demo1File {
    public static void main(String[] args) {
        /*
        * 1.操作路径不要写死
        * D:\_test  windows
        * D:/_test  linux
        * 将（/  或  \） 改成 D:"+File.separator+"_test
        *
        */

        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator); //路径分隔符  windows:分号； Linux：冒号：

        String separator = File.separator;
        System.out.println(separator);   //文件名称分隔符 windows：反斜杠\  Linux: 正斜杠



    }
}
