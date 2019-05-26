package com.bittech.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestStreamConvert {
    
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "__test" + File.separator + "b" + File.separator + "writer.txt");
        //字节流
        //InputStream -> FileInputStream
        try (InputStream in = new FileInputStream(file);
             //InputStream -> Reader
             //       InputStreamReader
             Reader reader = new InputStreamReader(in)
        ) {
            
            char[] buff = new char[1024];
            int len = -1;
            while ((len = reader.read(buff)) != -1) {
                System.out.print(new String(buff, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //面向接口
        //面向抽象类
        //interface  , abstract class
        //InputStream
        
    }
}
