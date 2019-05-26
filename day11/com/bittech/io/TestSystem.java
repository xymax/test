package com.bittech.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestSystem {
    public static void code1() {
        System.out.println("Hello World");
        //System  java.lang.System类
        //out     System类的静态属性 out对象 类型PrintStream
        //println()  PrintStream成员方法
        
        //out
        //日志系统（日志框架）
        //message -> file/database/kafka
//        try {
//            Integer.parseInt("abc");
//        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//            System.err.println(e.getMessage());
//        }

//       PrintStream out= System.out;
        OutputStream out = System.out;
        try {
            out.write("比特科技".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        try {
//            int b = inputStream.read();//阻塞
//            System.out.println((char) b);
            
            /*
            byte[] buff = new byte[8];
            int len = inputStream.read(buff);
            System.out.println("长度：" + len);
            System.out.println("数据：" + new String(buff, 0, len));
             */
            
            byte[] buff = new byte[5];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int len = -1;
            //file -> end
            //keyboard -> end
            while ((len = inputStream.read(buff)) != -1) {
                out.write(buff, 0, len);
                if (len < buff.length) {
                    break;
                }
            }
            System.out.println("输入的内容:" + new String(out.toByteArray()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
