package com.xy.hx.output;
/*
    一次写多个字节的方法:
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
/*        //1创建对象用匿名new File
        FileOutputStream fos =new FileOutputStream(new File("D:\\test\\a\\a1.txt"));
        //2.调用write方法
        fos.write(49);
        fos.write(48);
        fos.write(48);

        *//*
       public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
      一次写多个字节:
           如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
           如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
       *//*
        byte[] bytes={65,66,67,68,69,70};
        fos.write(bytes);

        *//*
            public void write(byte[] b, int off, int len) ：把字节数组的一部分写入到文件中
                int off:数组的开始索引
                int len:写几个字节
         *//*
        fos.write(bytes,3,2);//DE

        *//*
            写入字符的方法:可以使用String类中的方法把字符串,转换为字节数组
                byte[] getBytes()  把字符串转换为字节数组
         *//*
        byte[] bytes1 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes);


        //3.释放资源
        fos.close();*/
        FileOutputStream fos =new FileOutputStream("D:\\test\\a\\a2.txt");
        byte[] bytes = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes);
        fos.close();


    }
}
