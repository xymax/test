package com.bittech.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestPrintStream {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "__test" + File.separator + "printstream.txt");
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file))) {
            
            /*
            printStream.print("姓名：");
            printStream.println("张三");// ln => \n
            printStream.print("年龄：");
            printStream.println(28);
            */
            
            printStream.printf("姓名：%s  年龄：%d  身高：%.2f\n", "张三", 28, 176.456);
            printStream.printf("姓名：%s  年龄：%d  身高：%.2f", "张三", 28, 176.456);
            
            
            printStream.flush();
        } catch (IOException e) {
        
        }
    }
}
