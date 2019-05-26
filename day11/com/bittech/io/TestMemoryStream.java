package com.bittech.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestMemoryStream {
    
    public static void code1() {
        String content = "hello world";
        //要求：内存流 hello world => HELLO WORLD
        byte[] data = content.getBytes();
        // input -> convert -> output
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b = -1;
        while ((b = in.read()) != -1) {
            b = Character.toUpperCase(b);
            out.write(b);
        }
        byte[] newData = out.toByteArray();
        System.out.println(new String(newData));
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        //要求：
        // data-a.txt + data-b.txt => data.txt
        //实现方式
        //1. data-a.txt -> data.txt -> data-b.txt -> append data.txt  => 练习
        
        //2. data-a.txt -> ByteArrayOutputStream  data-b.txt -> ByteArrayOutputStream   ByteArrayOutputStream  byte[] -> FileOutputStream
        // (data.txt)
        
        String directory = "D:" + File.separator + "__test" + File.separator;
        try (FileInputStream fa = new FileInputStream(directory + "data-a.txt");
             FileInputStream fb = new FileInputStream(directory + "data-b.txt");
             FileOutputStream fdata = new FileOutputStream(directory + "data.txt");
             ByteArrayOutputStream memoryOut = new ByteArrayOutputStream()
        ) {
            
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = fa.read(buff)) != -1) {
                memoryOut.write(buff, 0, len);
            }
            while ((len = fb.read(buff)) != -1) {
                memoryOut.write(buff, 0, len);
            }
            byte[] mergeData = memoryOut.toByteArray();
            fdata.write(mergeData);
            fdata.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
