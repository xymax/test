package com.xy.hx.io;

import java.io.File;

public class Demo04File {
    /*
    File类判断功能的方法
        - public boolean exists() ：此File表示的文件或目录是否实际存在。
        - public boolean isDirectory() ：此File表示的是否为目录。
        - public boolean isFile() ：此File表示的是否为文件。
 */
    public static void main(String[] args) {
        show01();
        show02();

    }

    private static void show02() {
        /*
        public boolean isDirectory() ：此File表示的是否为目录。
            用于判断构造方法中给定的路径是否以文件夹结尾
                是:true
                否:false
        public boolean isFile() ：此File表示的是否为文件。
            用于判断构造方法中给定的路径是否以文件结尾
                是:true
                否:false
        注意:
            电脑的硬盘中只有文件/文件夹,两个方法是互斥
            这两个方法使用前提,路径必须是存在的,否则都返回false
       */
        File file=new File("D:\\tes\\a");
        if (file.exists()){
            System.out.println(file.isDirectory());  //false
            System.out.println(file.isFile());  //false
        }


        File file2=new File("D:\\test\\a");
        if (file2.exists()){
            System.out.println(file2.isDirectory());  //true
            System.out.println(file2.isFile());//false
        }
        File file3=new File("D:\\test\\a.png");
        if (file3.exists()){
            System.out.println(file3.isDirectory());//false
            System.out.println(file3.isFile()); //true
        }
    }

    private static void show01() {
    /*
        public boolean exists() ：此File表示的文件或目录是否实际存在。
        用于判断构造方法中的路径是否存在
            存在:true
            不存在:false
     */
        File file=new File("D:\\test\\a");
        System.out.println(file.exists());
        File file1=new File("D:\\tes\\a");
        System.out.println(file1.exists());
        File file2=new File("a.png");
        System.out.println(file2.exists());   //false
    }
}
