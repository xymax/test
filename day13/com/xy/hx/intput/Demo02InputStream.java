package com.xy.hx.intput;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =new FileInputStream("D:\\test\\a\\a1.txt");
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            System.out.println(new String());
        }
        fis.close();
    }
}
