package com.xy.hx.io;

import java.io.File;

public class Demo02File {

/*
* 路径：
*   1. 绝对路径：是一个完整的路径
*         以盘符（c：，D：）开始的路径
*   2.相对路径：是一个简化的路径
*     相对指的是相对于当前项目的根目录(C:\\Users\itcast\\IdeaProjects\\shungyuan)
            如果使用当前项目的根目录,路径可以简化书写
            C:\\Users\itcast\\IdeaProjects\\shungyuan\\123.txt-->简化为: 123.txt(可以省略项目的根目录)
*
*
* */
public static void main(String[] args) {
    /*
    * File类的构造方法
    */

    show01();
    show02("D:\\","a.text");
    show03();


}
    /*
            File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
            参数:把路径分成了两部分
                File parent:父路径
                String child:子路径
            好处:
                 父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
                 父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
         */
    private static void show03() {
        File parent =new File("D:\\");
        File file =new File(parent,"hello.java");
    }
 /*
        File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            String parent:父路径
            String child:子路径
        好处:
            父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
     */

    private static void show02(String parent ,String child) {
        File file1=new File(parent,child);
        System.out.println(file1);
    }
/*
File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
  String pathname:字符串的路径名称
            路径可以是以文件结尾,也可以是以文件夹结尾
            路径可以是相对路径,也可以是绝对路径
            路径可以是存在,也可以是不存在
            创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
*/


    private static void show01() {
        File f1=new File("D:\\_test");
        System.out.println(f1);//重写了Object类的toString方法
    }
}
